package com.xxlionxx.prometey.data.remote.mapper

import com.xxlionxx.prometey.data.remote.dto.OpenAIResponseDto
import com.xxlionxx.prometey.domain.model.AIModel
import com.xxlionxx.prometey.domain.model.AIProvider
import com.xxlionxx.prometey.domain.model.AIResponse

fun OpenAIResponseDto.toDomainResponse(): AIResponse {

    val text = output
        ?.flatMap { it.content.orEmpty() }
        ?.firstOrNull { it.type == "output_text" }
        ?.text
        .orEmpty()

    return AIResponse(
        content = text,
        model = AIModel(
            id = model.orEmpty(),
            provider = AIProvider.OPENAI,
            name = model.orEmpty(),
            isMultimodal = true
        ),
        createdAt = System.currentTimeMillis()
    )
}