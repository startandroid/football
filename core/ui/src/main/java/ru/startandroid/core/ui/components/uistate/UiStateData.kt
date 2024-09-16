package ru.startandroid.core.ui.components.uistate

import android.util.Log
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.startandroid.core.common.model.DataResult
import ru.startandroid.core.ui.model.UiState
import ru.startandroid.core.ui.model.toUiState

context(ViewModel)
@Stable
class UiStateData<T>(
    private val triggerOnInit: Boolean = true,
    private val func: suspend () -> DataResult<T>?
) {

    private val triggerFlow = MutableSharedFlow<Unit>(replay = 1)

    private var cachedData: UiState.Data<T>? = null

    val data = triggerFlow.flatMapLatest {
        flow {
            cachedData?.let {
                emit(it)
            } ?: emit(UiState.Loading)
            // used for testing Loading indicator
            delay(1000)
            val state = func().toUiState()
            if (state is UiState.Data) {
                cachedData = state
            }
            emit(state)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), UiState.Empty)

    init {
        if (triggerOnInit) trigger()
    }

    fun trigger() {
        viewModelScope.launch {
            triggerFlow.emit(Unit)
        }
    }
}
