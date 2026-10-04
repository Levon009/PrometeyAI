package com.xxlionxx.prometey.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xxlionxx.prometey.data.local.entity.AIKnowledgeEntity

@Dao
interface AIKnowledgeDao {

    @Query("SELECT * FROM ai_knowledge")
    suspend fun getKnowledge(): List<AIKnowledgeEntity>

    @Query("SELECT * FROM ai_knowledge WHERE id = :id")
    suspend fun getKnowledgeById(id: String): AIKnowledgeEntity?

    @Insert
    suspend fun insertKnowledge(knowledge: AIKnowledgeEntity)

    @Update
    suspend fun updateKnowledge(knowledge: AIKnowledgeEntity)

    @Delete
    suspend fun deleteKnowledge(knowledge: AIKnowledgeEntity)
}