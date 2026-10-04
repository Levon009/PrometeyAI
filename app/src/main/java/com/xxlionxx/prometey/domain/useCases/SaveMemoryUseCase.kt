package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.Memory
import com.xxlionxx.prometey.domain.repository.MemoryRepository

class SaveMemoryUseCase(
    private val memoryRepository: MemoryRepository
) {

    suspend operator fun invoke(memory: Memory) {
        memoryRepository.saveMemory(memory)
    }
}