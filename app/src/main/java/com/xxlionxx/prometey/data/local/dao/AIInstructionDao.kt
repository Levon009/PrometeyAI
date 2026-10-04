package com.xxlionxx.prometey.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xxlionxx.prometey.data.local.entity.AIInstructionEntity

@Dao
interface AIInstructionDao {

    @Query("SELECT * FROM ai_instructions WHERE isActive = 1 ORDER BY priority DESC")
    suspend fun getActiveInstructions(): List<AIInstructionEntity>

    @Query("SELECT * FROM ai_instructions WHERE id = :id")
    suspend fun getInstructionById(id: String): AIInstructionEntity?

    @Insert
    suspend fun insertInstruction(instruction: AIInstructionEntity)

    @Update
    suspend fun updateInstruction(instruction: AIInstructionEntity)

    @Delete
    suspend fun deleteInstruction(instruction: AIInstructionEntity)
}