package ru.startandroid.countries.view.ui.countries

import androidx.compose.runtime.Stable
import kotlinx.coroutines.flow.StateFlow
import ru.startandroid.core.ui.model.UiState
import ru.startandroid.countries.domain.model.Country

@Stable
interface CountriesHolder {
    val countries: StateFlow<UiState<List<Country>>>
    val imageSize: Int
    fun onCountryClick(country: Country)
    fun onRetry()
    fun getImageLoadedState(url: String): StateFlow<Boolean>
}