package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.UserPreference

interface UserPreferenceRepository {

    suspend fun getPreferences(userId: String): List<UserPreference>

    suspend fun savePreference(preference: UserPreference)

    suspend fun updatePreference(preference: UserPreference)

    suspend fun deletePreference(id: String)
}