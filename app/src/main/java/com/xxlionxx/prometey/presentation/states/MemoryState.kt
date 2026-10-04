package com.xxlionxx.prometey.presentation.states

import com.xxlionxx.prometey.domain.model.Memory

data class MemoryState(
    val memories: List<Memory> = emptyList(),
    val selectedMemory: Memory? = null,
    val isLoading: Boolean = false,
    val isSaving: Boolean = false,
    val isDeleting: Boolean = false,
    val error: String? = null
) : MviState
