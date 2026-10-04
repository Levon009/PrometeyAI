package com.xxlionxx.prometey.presentation.events

import com.xxlionxx.prometey.domain.model.UserPreference

sealed interface PreferenceEvent : MviEvent {

    data class LoadPreferences(val userId: String) : PreferenceEvent

    data class LoadPreferenceByKey(
        val userId: String,
        val key: String
    ) : PreferenceEvent

    data class SavePreference(val preference: UserPreference) : PreferenceEvent

    data class UpdatePreference(val preference: UserPreference) : PreferenceEvent

    data class DeletePreference(val preferenceId: String) : PreferenceEvent

    data class Refresh(val userId: String) : PreferenceEvent
}