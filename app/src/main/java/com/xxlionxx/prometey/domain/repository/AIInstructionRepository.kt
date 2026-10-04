package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.AIInstruction

interface AIInstructionRepository {

    suspend fun getActiveInstructions(): List<AIInstruction>

    suspend fun saveInstruction(instruction: AIInstruction)

    suspend fun updateInstruction(instruction: AIInstruction)

    suspend fun deleteInstruction(id: String)
}