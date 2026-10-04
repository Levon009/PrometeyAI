package com.xxlionxx.prometey.data.remote.dto

data class OpenAIOutputItemDto(
    val type: String?,
    val role: String?,
    val content: List<OpenAIOutputContentDto>?
)
