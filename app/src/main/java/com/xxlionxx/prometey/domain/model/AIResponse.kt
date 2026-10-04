package com.xxlionxx.prometey.domain.model

data class AIResponse(
    val content: String,
    val model: AIModel,
    val createdAt: Long
)
