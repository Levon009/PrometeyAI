package com.xxlionxx.prometey.presentation.states

import com.xxlionxx.prometey.domain.model.User
import com.xxlionxx.prometey.domain.model.UserProfile

data class ProfileState(
    val user: User? = null,
    val profile: UserProfile? = null,
    val isLoading: Boolean = false,
    val isSaving: Boolean = false,
    val error: String? = null
) : MviState
