package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.Memory
import com.xxlionxx.prometey.domain.repository.MemoryRepository

class UpdateMemoryUseCase(
    private val memoryRepository: MemoryRepository
) {

    suspend operator fun invoke(memory: Memory) {
        memoryRepository.updateMemory(memory)
    }
}