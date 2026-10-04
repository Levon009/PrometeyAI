package com.xxlionxx.prometey.domain.model

data class AIInstruction(
    val id: String,
    val name: String,
    val content: String,
    val priority: Int,
    val isActive: Boolean
)
