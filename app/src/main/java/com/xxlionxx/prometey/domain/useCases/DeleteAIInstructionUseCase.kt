package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.AIInstructionRepository

class DeleteAIInstructionUseCase(
    private val aiInstructionRepository: AIInstructionRepository
) {

    suspend operator fun invoke(id: String) {
        aiInstructionRepository.deleteInstruction(id)
    }
}