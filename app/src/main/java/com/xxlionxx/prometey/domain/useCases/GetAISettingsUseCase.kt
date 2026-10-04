package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.AISettings
import com.xxlionxx.prometey.domain.repository.AISettingsRepository

class GetAISettingsUseCase(
    private val aiSettingsRepository: AISettingsRepository
) {

    suspend operator fun invoke(): AISettings {
        return aiSettingsRepository.getSettings()
    }
}