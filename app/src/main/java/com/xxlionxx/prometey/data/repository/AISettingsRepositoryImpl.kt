package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.AIModelDao
import com.xxlionxx.prometey.data.local.dao.AISettingsDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.AISettings
import com.xxlionxx.prometey.domain.repository.AISettingsRepository

class AISettingsRepositoryImpl(
    private val settingsDao: AISettingsDao,
    private val modelDao: AIModelDao
) : AISettingsRepository {

    override suspend fun getSettings(): AISettings {
        val settings = settingsDao.getSettings("default")
            ?: throw IllegalStateException("AI settings not found")

        val model = modelDao.getModelById(settings.modelId)
            ?.toDomain()
            ?: throw IllegalStateException(
                "AI model not found: ${settings.modelId}"
            )

        return settings.toDomain(model)
    }

    override suspend fun saveSettings(
        settings: AISettings
    ) {
        settingsDao.insertSettings(
            settings.toEntity()
        )
    }

    override suspend fun updateSettings(
        settings: AISettings
    ) {
        settingsDao.updateSettings(
            settings.toEntity()
        )
    }
}