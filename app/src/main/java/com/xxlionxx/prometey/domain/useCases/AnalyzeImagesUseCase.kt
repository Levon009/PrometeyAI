package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.AIMessageContext
import com.xxlionxx.prometey.domain.model.AIResponse
import com.xxlionxx.prometey.domain.repository.AIImageRepository

class AnalyzeImagesUseCase(
    private val aiImageRepository: AIImageRepository
) {

    suspend operator fun invoke(context: AIMessageContext, imageUris: List<String>): AIResponse {
        require(imageUris.size <= 3) {
            "Maximum 3 images are allowed per request"
        }

        return aiImageRepository.analyzeImages(context, imageUris)
    }
}