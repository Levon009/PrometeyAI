package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.AISettings
import com.xxlionxx.prometey.domain.repository.AISettingsRepository

class UpdateAISettingsUseCase(
    private val aiSettingsRepository: AISettingsRepository
) {

    suspend operator fun invoke(settings: AISettings) {
        aiSettingsRepository.updateSettings(settings)
    }
}