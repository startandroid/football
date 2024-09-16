package ru.startandroid.core.ui.components.uistate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import kotlinx.coroutines.flow.StateFlow
import ru.startandroid.core.ui.model.UiState

@Composable
fun <T> ShowUiState(
    uiStateData: UiStateData<T>,
    onData: @Composable (data: T) -> Unit
) {
    val value = uiStateData.data.collectAsState().value
    ShowUiState(uiState = value, onRetry = uiStateData::trigger, onData = onData)
}


@Composable
fun <T> ShowUiState(
    uiState: StateFlow<UiState<T>>,
    onRetry: (() -> Unit)? = null,
    onData: @Composable (data: T) -> Unit
) {
    val value = uiState.collectAsState().value
    ShowUiState(uiState = value, onRetry = onRetry, onData = onData)
}

@Composable
fun <T> ShowUiState(
    uiState: UiState<T>,
    onRetry: (() -> Unit)? = null,
    onData: @Composable (data: T) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        when (uiState) {
            is UiState.None -> {}
            is UiState.Loading -> {

                CircularProgressIndicator(modifier = Modifier.align(Center))
            }
            is UiState.Empty -> Text(text = "No data", modifier = Modifier.align(Center))
            is UiState.Data -> onData(uiState.data)
            is UiState.Error -> {
                Column(
                    horizontalAlignment = CenterHorizontally,
                    modifier = Modifier.align(Center)
                ) {
                    Text(text = "Error: " + uiState.error)
                    onRetry?.let {
                        Button(onClick = it) {
                            Text(text = "Retry")
                        }
                    }
                }

            }
        }
    }
}
