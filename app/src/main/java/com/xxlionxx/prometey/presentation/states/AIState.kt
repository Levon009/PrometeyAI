package com.xxlionxx.prometey.presentation.states

import com.xxlionxx.prometey.domain.model.AIActionPermission
import com.xxlionxx.prometey.domain.model.AIActionPolicy
import com.xxlionxx.prometey.domain.model.AIBehavior
import com.xxlionxx.prometey.domain.model.AIInstruction
import com.xxlionxx.prometey.domain.model.AIKnowledge
import com.xxlionxx.prometey.domain.model.AIModel
import com.xxlionxx.prometey.domain.model.AISettings
import com.xxlionxx.prometey.domain.model.AIActionResult

data class AIState(
    val behavior: AIBehavior? = null,

    val activeInstructions: List<AIInstruction> = emptyList(),

    val knowledge: List<AIKnowledge> = emptyList(),
    val selectedKnowledge: AIKnowledge? = null,

    val availableModels: List<AIModel> = emptyList(),
    val selectedModel: AIModel? = null,

    val settings: AISettings? = null,

    val actionPolicy: AIActionPolicy? = null,
    val actionPermission: AIActionPermission? = null,
    val lastActionResult: AIActionResult? = null,

    val isLoading: Boolean = false,
    val isSaving: Boolean = false,
    val isDeleting: Boolean = false,
    val isExecutingAction: Boolean = false,

    val error: String? = null
) : MviState
