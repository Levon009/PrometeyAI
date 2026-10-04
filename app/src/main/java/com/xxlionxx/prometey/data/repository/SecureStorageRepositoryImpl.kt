package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.domain.repository.SecureStorageRepository

class SecureStorageRepositoryImpl : SecureStorageRepository {

    private val storage = mutableMapOf<String, String>()

    override suspend fun save(
        key: String,
        value: String
    ) {
        storage[key] = value
    }

    override suspend fun get(
        key: String
    ): String? {
        return storage[key]
    }

    override suspend fun delete(
        key: String
    ) {
        storage.remove(key)
    }

    override suspend fun contains(
        key: String
    ): Boolean {
        return storage.containsKey(key)
    }
}