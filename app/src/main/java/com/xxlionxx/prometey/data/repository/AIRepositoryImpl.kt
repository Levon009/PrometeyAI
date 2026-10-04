package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.remote.datasource.GeminiDataSource
import com.xxlionxx.prometey.data.remote.datasource.OpenAIDataSource
import com.xxlionxx.prometey.data.remote.dto.GeminiRequestDto
import com.xxlionxx.prometey.data.remote.dto.OpenAIMessageDto
import com.xxlionxx.prometey.data.remote.dto.OpenAIRequestDto
import com.xxlionxx.prometey.data.remote.mapper.toDomain
import com.xxlionxx.prometey.data.remote.mapper.toDomainResponse
import com.xxlionxx.prometey.domain.model.AIProvider
import com.xxlionxx.prometey.domain.model.AIMessageContext
import com.xxlionxx.prometey.domain.model.AIResponse
import com.xxlionxx.prometey.domain.repository.AIRepository
import com.xxlionxx.prometey.domain.repository.AISettingsRepository

class AIRepositoryImpl(
    private val aiSettingsRepository: AISettingsRepository,
    private val openAIDataSource: OpenAIDataSource,
    private val geminiDataSource: GeminiDataSource
) : AIRepository {

    override suspend fun generateResponse(
        context: AIMessageContext
    ): AIResponse {

        val settings = aiSettingsRepository.getSettings()
        val modelName = settings.model.id

        return when (settings.provider) {

            AIProvider.OPENAI -> {

                val request = OpenAIRequestDto(
                    model = modelName,
                    input = context.message.map { message ->
                        OpenAIMessageDto(
                            role = message.role.name.lowercase(),
                            content = message.content
                        )
                    }
                )

                openAIDataSource
                    .generateResponse(request)
                    .toDomainResponse()
            }

            AIProvider.GEMINI -> {

                val request = GeminiRequestDto(
                    model = modelName,
                    input = context.message
                        .joinToString("\n") { message ->
                            message.content
                        }
                )

                geminiDataSource
                    .generateResponse(request)
                    .toDomain(modelName)
            }

            AIProvider.LOCAL -> {
                throw IllegalStateException(
                    "Local AI provider is not supported"
                )
            }
        }
    }
}