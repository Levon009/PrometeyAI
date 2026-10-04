package com.xxlionxx.prometey.presentation.states

import com.xxlionxx.prometey.domain.model.UserGoal

data class GoalState(
    val goals: List<UserGoal> = emptyList(),
    val selectedGoal: UserGoal? = null,
    val isLoading: Boolean = false,
    val isSaving: Boolean = false,
    val isDeleting: Boolean = false,
    val error: String? = null
) : MviState