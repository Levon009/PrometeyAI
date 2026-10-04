package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.AIBehavior
import com.xxlionxx.prometey.domain.repository.AIBehaviorRepository

class SaveAIBehaviorUseCase(
    private val aiBehaviorRepository: AIBehaviorRepository
) {

    suspend operator fun invoke(behavior: AIBehavior) {
        aiBehaviorRepository.saveBehavior(behavior)
    }
}