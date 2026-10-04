package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.AppSettingsRepository

class SetAppSettingBooleanUseCase(
    private val appSettingsRepository: AppSettingsRepository
) {

    suspend operator fun invoke(
        key: String,
        value: Boolean
    ) {
        appSettingsRepository.setBoolean(
            key = key,
            value = value
        )
    }
}