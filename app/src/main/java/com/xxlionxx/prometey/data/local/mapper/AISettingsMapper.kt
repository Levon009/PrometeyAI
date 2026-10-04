package com.xxlionxx.prometey.data.local.mapper

import com.xxlionxx.prometey.data.local.entity.AISettingsEntity
import com.xxlionxx.prometey.domain.model.AISettings
import com.xxlionxx.prometey.domain.model.AIModel

fun AISettingsEntity.toDomain(
    model: AIModel
): AISettings {
    return AISettings(
        provider = model.provider,
        model = model,
        temperature = temperature,
        maxTokens = maxTokens
    )
}

fun AISettings.toEntity(): AISettingsEntity {
    return AISettingsEntity(
        id = "default",
        modelId = model.id,
        temperature = temperature,
        maxTokens = maxTokens,
        systemPrompt = null
    )
}