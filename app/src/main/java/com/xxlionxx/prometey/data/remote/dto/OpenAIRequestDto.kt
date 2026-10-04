package com.xxlionxx.prometey.data.remote.dto

data class OpenAIRequestDto(
    val model: String,
    val input: List<OpenAIMessageDto>
)
