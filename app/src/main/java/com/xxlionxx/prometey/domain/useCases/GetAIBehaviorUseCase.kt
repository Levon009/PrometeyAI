package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.AIBehavior
import com.xxlionxx.prometey.domain.repository.AIBehaviorRepository

class GetAIBehaviorUseCase(
    private val aiBehaviorRepository: AIBehaviorRepository
) {

    suspend operator fun invoke(): AIBehavior {
        return aiBehaviorRepository.getBehavior()
    }
}