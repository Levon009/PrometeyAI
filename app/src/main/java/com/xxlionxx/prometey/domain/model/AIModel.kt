package com.xxlionxx.prometey.domain.model

data class AIModel(
    val id: String,
    val provider: AIProvider,
    val name: String,
    val isMultimodal: Boolean
)
