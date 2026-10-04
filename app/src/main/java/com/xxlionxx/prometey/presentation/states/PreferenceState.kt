package com.xxlionxx.prometey.presentation.states

import com.xxlionxx.prometey.domain.model.UserPreference

data class PreferenceState(
    val preferences: List<UserPreference> = emptyList(),
    val selectedPreference: UserPreference? = null,
    val isLoading: Boolean = false,
    val isSaving: Boolean = false,
    val isDeleting: Boolean = false,
    val error: String? = null
) : MviState