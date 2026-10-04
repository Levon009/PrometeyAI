package com.xxlionxx.prometey.data.remote.dto

data class OpenAIImageInputDto(
    val role: String,
    val content: List<OpenAIImageContentDto>
)
