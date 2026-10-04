package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.MemoryRepository

class DeleteMemoryUseCase(
    private val memoryRepository: MemoryRepository
) {

    suspend operator fun invoke(id: String) {
        memoryRepository.deleteMemory(id)
    }
}