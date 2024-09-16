package ru.startandroid.core.ui.extensions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.startandroid.core.common.model.DataResult
import ru.startandroid.core.ui.model.UiState
import ru.startandroid.core.ui.model.toUiState

suspend fun <T> MutableStateFlow<UiState<T>>.loadData(func: suspend () -> DataResult<T>) {
    value = UiState.Loading
    value = func().toUiState()
}

context(ViewModel)
fun <T> MutableStateFlow<UiState<T>>.launchLoading(func: suspend () -> DataResult<T>) {
    viewModelScope.launch {
        loadData(func)
    }
}

