package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.AIKnowledge

interface AIKnowledgeRepository {

    suspend fun getKnowledge(topic: String): List<AIKnowledge>

    suspend fun getKnowledgeById(id: String): AIKnowledge?

    suspend fun saveKnowledge(knowledge: AIKnowledge)

    suspend fun updateKnowledge(knowledge: AIKnowledge)

    suspend fun deleteKnowledge(id: String)
}