package com.xxlionxx.prometey.domain.useCases


import com.xxlionxx.prometey.domain.model.AIModel
import com.xxlionxx.prometey.domain.repository.AIModelRepository

class GetAIModelByIdUseCase(
    private val aiModelRepository: AIModelRepository
) {

    suspend operator fun invoke(id: String): AIModel? {
        return aiModelRepository.getModelById(id)
    }
}