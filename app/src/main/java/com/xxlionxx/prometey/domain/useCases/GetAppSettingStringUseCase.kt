package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.AppSettingsRepository

class GetAppSettingStringUseCase(
    private val appSettingsRepository: AppSettingsRepository
) {

    suspend operator fun invoke(key: String): String? {
        return appSettingsRepository.getString(key)
    }
}