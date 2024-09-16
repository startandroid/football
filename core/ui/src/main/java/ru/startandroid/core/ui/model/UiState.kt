package ru.startandroid.core.ui.model

import ru.startandroid.core.common.model.DataResult

sealed class UiState<out T> {
    data object None : UiState<Nothing>()
    data object Loading : UiState<Nothing>()
    data object Empty : UiState<Nothing>()
    data class Data<T>(val data: T) : UiState<T>()
    data class Error(val error: DataResult.ErrorType) : UiState<Nothing>()

    fun getDataOrNull(): T? {
        return (this as? Data)?.data
    }
}

fun <T> DataResult<T>?.toUiState(): UiState<T> {
    if (this == null) return UiState.None
    if (error != null) return UiState.Error(error!!)
    if (data == null) return UiState.Empty
    if (data is Collection<*> && (data as Collection<*>).isEmpty()) return UiState.Empty
    return UiState.Data(data!!)
}


