package ru.startandroid.core.ui.model

data class UiStatePaged<T>(
    val data: List<T> = emptyList(),
    val nextPage: Int? = 1,
    val uiState: UiState<List<T>> = UiState.None
)