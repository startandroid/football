package ru.startandroid.core.ui.components.uistate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.startandroid.core.ui.model.UiState
import ru.startandroid.core.ui.model.UiStatePaged


@Composable
fun <T> ShowUiStatePaged(
    uiStatePagedData: UiStatePagedData<T>,
    onDataItem: @Composable (data: T) -> Unit
) {
    val data = uiStatePagedData.data.collectAsState().value
    ShowUiStatePaged(
        uiStatePaged = data,
        onNextPage = uiStatePagedData::fetchNextPage,
        onDataItem = onDataItem
    )
}


@Composable
fun <T> ShowUiStatePaged(
    uiStatePaged: UiStatePaged<T>,
    onNextPage: () -> Unit,
    onDataItem: @Composable (data: T) -> Unit
) {
    if (uiStatePaged.data.isEmpty()) {
        ShowUiState(
            uiState = uiStatePaged.uiState,
            onRetry = uiStatePaged.nextPage?.let{ { onNextPage() } }
        ) { }
        return
    }

    LazyColumn {
        items(uiStatePaged.data) {
            onDataItem(it)
        }
        item {
            when (uiStatePaged.uiState) {
                is UiState.None -> {}
                is UiState.Loading -> Footer { CircularProgressIndicator() }
                is UiState.Empty -> {}
                is UiState.Data -> uiStatePaged.nextPage?.let {
                    Footer {
                        Button(onClick = { onNextPage() }) {
                            Text("Show more")
                        }
                    }
                }
                is UiState.Error -> {
                    Footer {
                        Row(
                            verticalAlignment = CenterVertically,
                        ) {
                            Text(text = "Error: " + uiStatePaged.uiState.error)
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(onClick = { onNextPage() }) {
                                Text(text = "Retry")
                            }
                        }
                    }
                }
            }
        }
    }

}

@Composable
private fun Footer(
    footer: @Composable () -> Unit
) {
    Box(
        contentAlignment = Center,
        modifier = Modifier.fillMaxWidth().height(48.dp)
    ) {
        footer()
    }
}