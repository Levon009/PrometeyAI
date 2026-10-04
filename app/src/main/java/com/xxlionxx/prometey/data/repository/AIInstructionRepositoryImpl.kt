package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.AIInstructionDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.AIInstruction
import com.xxlionxx.prometey.domain.repository.AIInstructionRepository

class AIInstructionRepositoryImpl(
    private val dao: AIInstructionDao
) : AIInstructionRepository {

    override suspend fun getActiveInstructions(): List<AIInstruction> {
        return dao.getActiveInstructions()
            .map { it.toDomain() }
    }

    override suspend fun saveInstruction(
        instruction: AIInstruction
    ) {
        dao.insertInstruction(
            instruction.toEntity()
        )
    }

    override suspend fun updateInstruction(
        instruction: AIInstruction
    ) {
        dao.updateInstruction(
            instruction.toEntity()
        )
    }

    override suspend fun deleteInstruction(id: String) {
        val instruction = dao.getInstructionById(id) ?: return
        dao.deleteInstruction(instruction)
    }
}