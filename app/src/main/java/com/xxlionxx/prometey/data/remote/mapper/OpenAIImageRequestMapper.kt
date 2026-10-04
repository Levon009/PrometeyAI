package com.xxlionxx.prometey.data.remote.mapper

import com.xxlionxx.prometey.data.remote.dto.OpenAIImageContentDto
import com.xxlionxx.prometey.data.remote.dto.OpenAIImageInputDto
import com.xxlionxx.prometey.data.remote.dto.OpenAIImageRequestDto
import com.xxlionxx.prometey.domain.model.AIMessageContext
import com.xxlionxx.prometey.domain.model.MessageRole

fun AIMessageContext.toOpenAIImageRequest(
    imageUris: List<String>,
    model: String
): OpenAIImageRequestDto {

    val messages = mutableListOf<OpenAIImageInputDto>()

    message.forEach { currentMessage ->

        messages.add(
            OpenAIImageInputDto(
                role = when (currentMessage.role) {
                    MessageRole.USER -> "user"
                    MessageRole.ASSISTANT -> "assistant"
                    MessageRole.SYSTEM -> "system"
                },
                content = listOf(
                    OpenAIImageContentDto(
                        type = when (currentMessage.role) {
                            MessageRole.SYSTEM -> "input_text"
                            else -> "input_text"
                        },
                        text = currentMessage.content
                    )
                )
            )
        )
    }

    val imageContent = imageUris.map { uri ->
        OpenAIImageContentDto(
            type = "input_image",
            imageUrl = uri,
            detail = "auto"
        )
    }

    if (messages.isEmpty()) {
        messages.add(
            OpenAIImageInputDto(
                role = "user",
                content = imageContent
            )
        )
    } else {
        val lastMessage = messages.last()

        messages[messages.lastIndex] = lastMessage.copy(
            content = lastMessage.content + imageContent
        )
    }

    return OpenAIImageRequestDto(
        model = model,
        input = messages
    )
}