package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.AIInstruction
import com.xxlionxx.prometey.domain.repository.AIInstructionRepository

class UpdateAIInstructionUseCase(
    private val aiInstructionRepository: AIInstructionRepository
) {

    suspend operator fun invoke(instruction: AIInstruction) {
        aiInstructionRepository.updateInstruction(instruction)
    }
}