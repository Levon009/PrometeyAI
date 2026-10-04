package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.AppSettingsRepository

class SetAppSettingStringUseCase(
    private val appSettingsRepository: AppSettingsRepository
) {

    suspend operator fun invoke(key: String, value: String) {
        appSettingsRepository.setString(
            key = key,
            value = value
        )
    }
}