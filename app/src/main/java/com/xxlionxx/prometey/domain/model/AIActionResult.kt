package com.xxlionxx.prometey.domain.model

data class AIActionResult(
    val action: AIAction,
    val success: Boolean,
    val message: String?
)
