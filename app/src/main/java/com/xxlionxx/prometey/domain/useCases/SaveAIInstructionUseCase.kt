package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.AIInstruction
import com.xxlionxx.prometey.domain.repository.AIInstructionRepository

class SaveAIInstructionUseCase(
    private val aiInstructionRepository: AIInstructionRepository
) {

    suspend operator fun invoke(instruction: AIInstruction) {
        aiInstructionRepository.saveInstruction(instruction)
    }
}