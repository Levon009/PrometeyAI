package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.AIInstruction
import com.xxlionxx.prometey.domain.repository.AIInstructionRepository

class GetActiveAIInstructionsUseCase(
    private val aiInstructionRepository: AIInstructionRepository
) {

    suspend operator fun invoke(): List<AIInstruction> {
        return aiInstructionRepository.getActiveInstructions()
    }
}