package ru.startandroid.core.ui.components.uistate

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.startandroid.core.common.model.DataResult
import ru.startandroid.core.ui.model.UiState
import ru.startandroid.core.ui.model.UiStatePaged
import ru.startandroid.core.ui.model.toUiState

context(androidx.lifecycle.ViewModel)
class UiStatePagedData<T>(
    private val func: suspend (Int) -> DataResult<List<T>>?
) {

    private val triggerFlow = MutableSharedFlow<Unit>(replay = 1)

    private val _data = MutableStateFlow<UiStatePaged<T>>(UiStatePaged())
    val data = _data.asStateFlow()

    init {
        fetchNextPage()
    }

    fun fetchNextPage() {
        val page = _data.value.nextPage ?: return
        viewModelScope.launch {
            _data.update {
                it.copy(uiState = UiState.Loading)
            }
            // used for testing Loading indicator
            delay(1000)
            val dataResult = func(page)
            val uiState = dataResult.toUiState()
            _data.update {
                if (uiState is UiState.Error || uiState is UiState.None) {
                    it.copy(
                        uiState = uiState
                    )
                } else {
                    it.copy(
                        data = it.data + (dataResult?.data ?: emptyList()),
                        nextPage = dataResult?.nextPage,
                        uiState = uiState
                    )
                }
            }
        }
    }

    fun refresh() {
        _data.value = UiStatePaged()
        fetchNextPage()
    }



}