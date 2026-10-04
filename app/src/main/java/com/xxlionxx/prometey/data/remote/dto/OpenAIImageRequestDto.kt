package com.xxlionxx.prometey.data.remote.dto

data class OpenAIImageRequestDto(
    val model: String,
    val input: List<OpenAIImageInputDto>
)
