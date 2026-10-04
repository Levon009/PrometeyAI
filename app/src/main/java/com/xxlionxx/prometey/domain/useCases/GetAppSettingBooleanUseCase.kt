package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.AppSettingsRepository

class GetAppSettingBooleanUseCase(
    private val appSettingsRepository: AppSettingsRepository
) {

    suspend operator fun invoke(key: String): Boolean? {
        return appSettingsRepository.getBoolean(key)
    }
}