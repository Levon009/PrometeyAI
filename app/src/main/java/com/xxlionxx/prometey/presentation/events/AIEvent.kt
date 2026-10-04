package com.xxlionxx.prometey.presentation.events

import com.xxlionxx.prometey.domain.model.AIAction
import com.xxlionxx.prometey.domain.model.AIActionPolicy
import com.xxlionxx.prometey.domain.model.AIBehavior
import com.xxlionxx.prometey.domain.model.AIInstruction
import com.xxlionxx.prometey.domain.model.AIKnowledge
import com.xxlionxx.prometey.domain.model.AISettings

sealed interface AIEvent : MviEvent {

    // AI Behavior
    data object LoadBehavior : AIEvent

    data class SaveBehavior(
        val behavior: AIBehavior
    ) : AIEvent

    data class UpdateBehavior(
        val behavior: AIBehavior
    ) : AIEvent

    // AI Instructions
    data object LoadActiveInstructions : AIEvent

    data class SaveInstruction(
        val instruction: AIInstruction
    ) : AIEvent

    data class UpdateInstruction(
        val instruction: AIInstruction
    ) : AIEvent

    data class DeleteInstruction(
        val instructionId: String
    ) : AIEvent

    // AI Knowledge
    data class LoadKnowledge(
        val topic: String
    ) : AIEvent

    data class LoadKnowledgeById(
        val knowledgeId: String
    ) : AIEvent

    data class SaveKnowledge(
        val knowledge: AIKnowledge
    ) : AIEvent

    data class UpdateKnowledge(
        val knowledge: AIKnowledge
    ) : AIEvent

    data class DeleteKnowledge(
        val knowledgeId: String
    ) : AIEvent

    // AI Models
    data object LoadAvailableModels : AIEvent

    data class LoadModel(
        val modelId: String
    ) : AIEvent

    // AI Settings
    data object LoadSettings : AIEvent

    data class SaveSettings(
        val settings: AISettings
    ) : AIEvent

    data class UpdateSettings(
        val settings: AISettings
    ) : AIEvent

    // AI Action Policy
    data object LoadActionPolicy : AIEvent

    data class SaveActionPolicy(
        val policy: AIActionPolicy
    ) : AIEvent

    data class UpdateActionPolicy(
        val policy: AIActionPolicy
    ) : AIEvent

    // AI Actions
    data class GetActionPermission(
        val action: AIAction
    ) : AIEvent

    data class ExecuteAction(
        val action: AIAction,
        val parameters: Map<String, String>
    ) : AIEvent

    // General
    data object ClearAIState : AIEvent
}