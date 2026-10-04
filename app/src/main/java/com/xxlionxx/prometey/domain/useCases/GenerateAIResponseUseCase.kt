package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.AIMessageContext
import com.xxlionxx.prometey.domain.model.AIResponse
import com.xxlionxx.prometey.domain.repository.AIRepository

class GenerateAIResponseUseCase(
    private val aiRepository: AIRepository
) {

    suspend operator fun invoke(context: AIMessageContext): AIResponse {
        return aiRepository.generateResponse(context)
    }
}