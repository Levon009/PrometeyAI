package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.AISettings

interface AISettingsRepository {

    suspend fun getSettings(): AISettings

    suspend fun saveSettings(settings: AISettings)

    suspend fun updateSettings(settings: AISettings)
}