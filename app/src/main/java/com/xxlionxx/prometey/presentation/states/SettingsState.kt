package com.xxlionxx.prometey.presentation.states

import com.xxlionxx.prometey.domain.model.AIModel
import com.xxlionxx.prometey.domain.model.AISettings

data class SettingsState(
    val aiSettings: AISettings? = null,
    val availableAIModels: List<AIModel> = emptyList(),

    val booleanSettings: Map<String, Boolean?> = emptyMap(),
    val stringSettings: Map<String, String?> = emptyMap(),

    val secureValues: Map<String, String?> = emptyMap(),
    val secureValuePresence: Map<String, Boolean> = emptyMap(),

    val isLoading: Boolean = false,
    val isSaving: Boolean = false,
    val isDeleting: Boolean = false,

    val error: String? = null
) : MviState