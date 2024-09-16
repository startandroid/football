package ru.startandroid.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun <T> NavController.SetResult(key: String, value: StateFlow<T?>) {
    LaunchedEffect(Unit) {
        value.collect {
            if (it == null) return@collect
            previousBackStackEntry?.savedStateHandle?.set(key, it)
            popBackStack()
        }
    }
}

@Composable
fun <T> NavController.GetResult(key: String, onResult: (T) -> Unit) {
    LaunchedEffect(Unit) {
        val currentBackStackEntry = currentBackStackEntry ?: return@LaunchedEffect
        currentBackStackEntry.savedStateHandle
            .getStateFlow<T?>(key, null)
            .collect {
                if (it != null) {
                    onResult(it)
                    currentBackStackEntry.savedStateHandle[key] = null
                }
            }

    }
}