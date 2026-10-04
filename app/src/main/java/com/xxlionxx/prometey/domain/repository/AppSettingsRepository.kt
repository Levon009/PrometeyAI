package com.xxlionxx.prometey.domain.repository

interface AppSettingsRepository {

    suspend fun getString(key: String): String?

    suspend fun setString(key: String, value: String)

    suspend fun getBoolean(key: String): Boolean?

    suspend fun setBoolean(key: String, value: Boolean)

    suspend fun remove(key: String)
}