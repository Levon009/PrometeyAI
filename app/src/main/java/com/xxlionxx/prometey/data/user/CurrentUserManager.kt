package com.xxlionxx.prometey.data.user

import com.xxlionxx.prometey.domain.repository.AppSettingsRepository
import java.util.UUID

class CurrentUserManager(
    private val appSettingsRepository: AppSettingsRepository
) {

    suspend fun getCurrentUserId(): String {
        val existingUserId = appSettingsRepository.getString(CURRENT_USER_ID_KEY)

        if (!existingUserId.isNullOrBlank()) {
            return existingUserId
        }

        val newUserId = UUID.randomUUID().toString()

        appSettingsRepository.setString(
            key = CURRENT_USER_ID_KEY,
            value = newUserId
        )

        return newUserId
    }

    companion object {
        private const val CURRENT_USER_ID_KEY = "prometey_current_user_id"
    }
}