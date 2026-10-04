package com.xxlionxx.prometey.data.remote.mapper

import com.xxlionxx.prometey.data.remote.dto.GeminiRequestDto
import com.xxlionxx.prometey.domain.model.AIMessageContext

fun AIMessageContext.toGeminiRequest(
    model: String
): GeminiRequestDto {

    val input = message
        .joinToString("\n") { currentMessage ->
            currentMessage.content
        }

    return GeminiRequestDto(
        model = model,
        input = input
    )
}