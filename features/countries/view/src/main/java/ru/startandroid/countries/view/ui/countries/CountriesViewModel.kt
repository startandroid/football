package ru.startandroid.countries.view.ui.countries

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.ImageLoader
import coil.decode.SvgDecoder
//import coil.decode.SvgDecoder
import coil.request.ImageRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.core.ui.model.UiState
import ru.startandroid.core.ui.model.toUiState
import ru.startandroid.countries.api.model.CountryExt
import ru.startandroid.countries.domain.model.Country
import ru.startandroid.countries.domain.usecase.GetCountriesUseCase
import ru.startandroid.countries.domain.usecase.invoke
import java.util.concurrent.CopyOnWriteArrayList
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val app: Application,
    private val imageLoader: ImageLoader,
    private val countryMapper: Mapper<Country, CountryExt>
) : ViewModel(), CountriesHolder {

    private val numberOfParallelJobs = 2
    override val imageSize = 64
    private val pxSize = dpToPx(imageSize, app.applicationContext).toInt()

    private val triggerFlow = MutableSharedFlow<Unit>(replay = 1)

    override val countries = triggerFlow.flatMapLatest {
        flow {
            emit(UiState.Loading)
            // used for testing Loading indicator
            delay(1000)
            emit(getCountriesUseCase().toUiState())
            prepareFlags()
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), UiState.Empty)

    private val _selectedCountry = MutableStateFlow<CountryExt?>(null)
    val selectedCountry = _selectedCountry.asStateFlow()

    private val requests = mutableMapOf<String, MutableStateFlow<Boolean>>()

    init {
        trigger()
    }

    override fun onCountryClick(country: Country) {
        _selectedCountry.value = countryMapper.map(country)
    }

    override fun onRetry() {
        trigger()
    }

    private fun trigger() {
        viewModelScope.launch {
            triggerFlow.emit(Unit)
        }
    }

    private fun prepareFlags() {
        val flags = countries.value.getDataOrNull().orEmpty()
            .mapNotNull { it.flag }
        flags.forEach { url ->
            requests[url] = MutableStateFlow(false)
        }
        loadFlags(flags)
    }

    private fun loadFlags(list: List<String>) {
        if (list.isEmpty()) return
        val syncedList = CopyOnWriteArrayList(list)
        val decFactory = SvgDecoder.Factory()
        repeat(numberOfParallelJobs) {
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    while (syncedList.isNotEmpty() && isActive) {
                        val url = syncedList.removeAt(0)
                        val state = requests[url]
                        val request = ImageRequest.Builder(app.applicationContext)
                            .data(url)
                            .decoderFactory(decFactory)
                            .size(pxSize, pxSize)
                            .listener(
                                onSuccess = { _, _ ->
                                    state?.value = true
                                }
                            )
                            .build()
                        imageLoader.execute(request)
                    }
                }
            }
        }
    }


    override fun getImageLoadedState(url: String): StateFlow<Boolean> {
        val state = requests[url]
        return state ?: MutableStateFlow(false)
    }

    private fun dpToPx(dp: Int, ctx: Context): Float {
        val density = ctx.resources.displayMetrics.density
        return dp * density
    }

}


