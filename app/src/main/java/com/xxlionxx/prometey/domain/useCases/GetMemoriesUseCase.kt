package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.Memory
import com.xxlionxx.prometey.domain.repository.MemoryRepository

class GetMemoriesUseCase(
    private val memoryRepository: MemoryRepository
) {

    suspend operator fun invoke(userId: String): List<Memory> {
        return memoryRepository.getMemories(userId)
    }
}