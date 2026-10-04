package com.xxlionxx.prometey.data.repository

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.xxlionxx.prometey.data.local.appSettingsDataStore
import com.xxlionxx.prometey.domain.repository.AppSettingsRepository
import kotlinx.coroutines.flow.first

class AppSettingsRepositoryImpl(
    private val context: Context
) : AppSettingsRepository {

    override suspend fun getString(
        key: String
    ): String? {
        val preferences = context.appSettingsDataStore.data.first()
        return preferences[stringPreferencesKey(key)]
    }

    override suspend fun setString(
        key: String,
        value: String
    ) {
        context.appSettingsDataStore.edit { preferences ->
            preferences[stringPreferencesKey(key)] = value
        }
    }

    override suspend fun getBoolean(
        key: String
    ): Boolean? {
        val preferences = context.appSettingsDataStore.data.first()
        return preferences[booleanPreferencesKey(key)]
    }

    override suspend fun setBoolean(
        key: String,
        value: Boolean
    ) {
        context.appSettingsDataStore.edit { preferences ->
            preferences[booleanPreferencesKey(key)] = value
        }
    }

    override suspend fun remove(
        key: String
    ) {
        context.appSettingsDataStore.edit { preferences ->
            preferences.remove(stringPreferencesKey(key))
            preferences.remove(booleanPreferencesKey(key))
        }
    }
}