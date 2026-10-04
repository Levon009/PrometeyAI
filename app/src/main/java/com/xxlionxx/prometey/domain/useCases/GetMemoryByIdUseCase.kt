package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.Memory
import com.xxlionxx.prometey.domain.repository.MemoryRepository

class GetMemoryByIdUseCase(
    private val memoryRepository: MemoryRepository
) {

    suspend operator fun invoke(id: String): Memory? {
        return memoryRepository.getMemoryById(id)
    }
}