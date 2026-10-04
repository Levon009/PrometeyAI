package com.xxlionxx.prometey.presentation

import androidx.lifecycle.ViewModel
import com.xxlionxx.prometey.presentation.events.MviEvent
import com.xxlionxx.prometey.presentation.states.MviState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Base ViewModel for Prometey's MVI presentation architecture.
 *
 * E = Event
 * S = State
 */
abstract class MviViewModel<E : MviEvent, S : MviState>(
    initialState: S
) : ViewModel() {

    private val _state = MutableStateFlow(initialState)

    val state: StateFlow<S> = _state.asStateFlow()

    protected fun updateState(reducer: (S) -> S) {
        _state.value = reducer(_state.value)
    }

    abstract fun onEvent(event: E)
}