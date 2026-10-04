package com.xxlionxx.prometey.domain.repository

interface SecureStorageRepository {

    suspend fun save(key: String, value: String)

    suspend fun get(key: String): String?

    suspend fun delete(key: String)

    suspend fun contains(key: String): Boolean
}