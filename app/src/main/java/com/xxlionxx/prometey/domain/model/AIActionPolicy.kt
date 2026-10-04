package com.xxlionxx.prometey.domain.model

data class AIActionPolicy(
    val permissions: List<AIActionPermission>,
    val allowAutomaticActions: Boolean
)
