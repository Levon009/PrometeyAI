package com.xxlionxx.prometey.domain.model

data class AIActionPermission(
    val action: AIAction,
    val isAllowed: Boolean,
    val requiresConfirmation: Boolean
)
