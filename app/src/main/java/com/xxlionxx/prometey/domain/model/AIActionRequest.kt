package com.xxlionxx.prometey.domain.model

data class AIActionRequest(
    val action: AIAction,
    val parameters: Map<String, String>
)
