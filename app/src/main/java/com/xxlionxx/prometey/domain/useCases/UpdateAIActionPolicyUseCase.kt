package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.AIActionPolicy
import com.xxlionxx.prometey.domain.repository.AIActionPolicyRepository

class UpdateAIActionPolicyUseCase(
    private val aiActionPolicyRepository: AIActionPolicyRepository
) {

    suspend operator fun invoke(policy: AIActionPolicy) {
        aiActionPolicyRepository.updatePolicy(policy)
    }
}