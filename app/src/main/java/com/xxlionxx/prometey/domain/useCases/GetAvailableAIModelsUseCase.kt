package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.AIModel
import com.xxlionxx.prometey.domain.repository.AIModelRepository

class GetAvailableAIModelsUseCase(
    private val aiModelRepository: AIModelRepository
) {

    suspend operator fun invoke(): List<AIModel> {
        return aiModelRepository.getAvailableModels()
    }
}