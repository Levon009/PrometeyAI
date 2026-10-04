package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.MemoryDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.Memory
import com.xxlionxx.prometey.domain.repository.MemoryRepository

class MemoryRepositoryImpl(
    private val dao: MemoryDao
) : MemoryRepository {

    override suspend fun getMemories(
        userId: String
    ): List<Memory> {
        return dao.getMemories(userId)
            .map { it.toDomain() }
    }

    override suspend fun getMemoryById(
        id: String
    ): Memory? {
        return dao.getMemoryById(id)
            ?.toDomain()
    }

    override suspend fun saveMemory(
        memory: Memory
    ) {
        dao.insertMemory(
            memory.toEntity()
        )
    }

    override suspend fun updateMemory(
        memory: Memory
    ) {
        dao.updateMemory(
            memory.toEntity()
        )
    }

    override suspend fun deleteMemory(
        id: String
    ) {
        val memory = dao.getMemoryById(id)
            ?: return

        dao.deleteMemory(memory)
    }
}