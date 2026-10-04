package com.xxlionxx.prometey.data.remote.mapper

import com.xxlionxx.prometey.data.remote.dto.OpenAIMessageDto
import com.xxlionxx.prometey.data.remote.dto.OpenAIRequestDto
import com.xxlionxx.prometey.domain.model.AIMessageContext
import com.xxlionxx.prometey.domain.model.MessageRole

fun AIMessageContext.toOpenAIRequest(
    model: String
): OpenAIRequestDto {

    val messages = message.map { currentMessage ->
        OpenAIMessageDto(
            role = when (currentMessage.role) {
                MessageRole.USER -> "user"
                MessageRole.ASSISTANT -> "assistant"
                MessageRole.SYSTEM -> "system"
            },
            content = currentMessage.content
        )
    }

    return OpenAIRequestDto(
        model = model,
        input = messages
    )
}