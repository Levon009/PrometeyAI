package com.xxlionxx.prometey.domain.model

data class AIConversationSettings(
    val model: AIModel,
    val behavior: AIBehavior,
    val actionPolicy: AIActionPolicy
)
