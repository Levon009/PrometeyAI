package com.xxlionxx.prometey.data.remote.dto

data class OpenAIResponseDto(
    val id: String?,
    val model: String?,
    val output: List<OpenAIOutputItemDto>?
)
