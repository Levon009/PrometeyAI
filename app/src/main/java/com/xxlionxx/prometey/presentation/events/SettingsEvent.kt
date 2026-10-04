package com.xxlionxx.prometey.presentation.events

import com.xxlionxx.prometey.domain.model.AISettings

sealed interface SettingsEvent : MviEvent {

    // AI Settings
    data object LoadAvailableAIModels : SettingsEvent

    data object LoadAISettings : SettingsEvent

    data class SaveAISettings(
        val settings: AISettings
    ) : SettingsEvent

    data class UpdateAISettings(
        val settings: AISettings
    ) : SettingsEvent

    // App Boolean Settings
    data class LoadBooleanSetting(
        val key: String
    ) : SettingsEvent

    data class SetBooleanSetting(
        val key: String,
        val value: Boolean
    ) : SettingsEvent

    // App String Settings
    data class LoadStringSetting(
        val key: String
    ) : SettingsEvent

    data class SetStringSetting(
        val key: String,
        val value: String
    ) : SettingsEvent

    data class RemoveAppSetting(
        val key: String
    ) : SettingsEvent

    // Secure Storage
    data class CheckSecureValue(
        val key: String
    ) : SettingsEvent

    data class LoadSecureValue(
        val key: String
    ) : SettingsEvent

    data class SaveSecureValue(
        val key: String,
        val value: String
    ) : SettingsEvent

    data class DeleteSecureValue(
        val key: String
    ) : SettingsEvent

    data object ClearSettings : SettingsEvent
}