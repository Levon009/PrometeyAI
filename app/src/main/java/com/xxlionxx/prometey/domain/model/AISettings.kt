package com.xxlionxx.prometey.domain.model

data class AISettings(
    val provider: AIProvider,
    val model: AIModel,
    val temperature: Float,
    val maxTokens: Int
)
