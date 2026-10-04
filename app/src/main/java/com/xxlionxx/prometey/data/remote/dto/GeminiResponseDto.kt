package com.xxlionxx.prometey.data.remote.dto

data class GeminiResponseDto(
    val id: String?,
    val model: String?,
    val status: String?,
    val outputs: List<GeminiOutputDto>?
)

data class GeminiOutputDto(
    val type: String?,
    val text: String?
)