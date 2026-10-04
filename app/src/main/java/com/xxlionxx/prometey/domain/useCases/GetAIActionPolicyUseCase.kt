package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.AIActionPolicy
import com.xxlionxx.prometey.domain.repository.AIActionPolicyRepository

class GetAIActionPolicyUseCase(
    private val aiActionPolicyRepository: AIActionPolicyRepository
) {

    suspend operator fun invoke(): AIActionPolicy {
        return aiActionPolicyRepository.getPolicy()
    }
}