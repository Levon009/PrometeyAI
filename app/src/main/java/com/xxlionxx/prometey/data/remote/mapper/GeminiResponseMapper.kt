package com.xxlionxx.prometey.data.remote.mapper

import com.xxlionxx.prometey.data.remote.dto.GeminiResponseDto
import com.xxlionxx.prometey.domain.model.AIModel
import com.xxlionxx.prometey.domain.model.AIProvider
import com.xxlionxx.prometey.domain.model.AIResponse

fun GeminiResponseDto.toDomain(
    modelName: String
): AIResponse {

    val content = outputs
        ?.firstOrNull { it.type == "text" }
        ?.text
        ?: outputs
            ?.firstOrNull()
            ?.text
        ?: throw IllegalStateException(
            "Gemini response did not contain text"
        )

    return AIResponse(
        content = content,
        model = AIModel(
            id = modelName,
            provider = AIProvider.GEMINI,
            name = modelName,
            isMultimodal = true
        ),
        createdAt = System.currentTimeMillis()
    )
}