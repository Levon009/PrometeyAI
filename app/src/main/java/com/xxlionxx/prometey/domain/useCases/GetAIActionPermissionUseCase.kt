package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.AIAction
import com.xxlionxx.prometey.domain.model.AIActionPermission
import com.xxlionxx.prometey.domain.repository.AIActionRepository

class GetAIActionPermissionUseCase(
    private val aiActionRepository: AIActionRepository
) {

    suspend operator fun invoke(action: AIAction): AIActionPermission {
        return aiActionRepository.getPermission(action)
    }
}