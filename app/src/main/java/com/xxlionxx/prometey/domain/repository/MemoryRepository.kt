package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.Memory

interface MemoryRepository {

    suspend fun getMemories(userId: String): List<Memory>

    suspend fun getMemoryById(id: String): Memory?

    suspend fun saveMemory(memory: Memory)

    suspend fun updateMemory(memory: Memory)

    suspend fun deleteMemory(id: String)
}