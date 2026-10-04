package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.AppSettingsRepository

class RemoveAppSettingUseCase(
    private val appSettingsRepository: AppSettingsRepository
) {

    suspend operator fun invoke(key: String) {
        appSettingsRepository.remove(key)
    }
}