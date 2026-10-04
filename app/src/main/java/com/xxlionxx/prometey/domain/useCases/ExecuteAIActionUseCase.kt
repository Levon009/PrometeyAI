package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.AIAction
import com.xxlionxx.prometey.domain.model.AIActionResult
import com.xxlionxx.prometey.domain.repository.AIActionRepository

class ExecuteAIActionUseCase(
    private val aiActionRepository: AIActionRepository
) {

    suspend operator fun invoke(action: AIAction, parameters: Map<String, String>): AIActionResult {
        return aiActionRepository.execute(action, parameters)
    }
}