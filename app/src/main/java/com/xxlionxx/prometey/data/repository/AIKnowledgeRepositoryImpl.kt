package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.AIKnowledgeDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.AIKnowledge
import com.xxlionxx.prometey.domain.repository.AIKnowledgeRepository

class AIKnowledgeRepositoryImpl(
    private val dao: AIKnowledgeDao
) : AIKnowledgeRepository {

    override suspend fun getKnowledge(
        topic: String
    ): List<AIKnowledge> {
        return dao.getKnowledge()
            .filter { it.topic == topic }
            .map { it.toDomain() }
    }

    override suspend fun getKnowledgeById(
        id: String
    ): AIKnowledge? {
        return dao.getKnowledgeById(id)?.toDomain()
    }

    override suspend fun saveKnowledge(
        knowledge: AIKnowledge
    ) {
        dao.insertKnowledge(
            knowledge.toEntity()
        )
    }

    override suspend fun updateKnowledge(
        knowledge: AIKnowledge
    ) {
        dao.updateKnowledge(
            knowledge.toEntity()
        )
    }

    override suspend fun deleteKnowledge(
        id: String
    ) {
        val knowledge = dao.getKnowledgeById(id)
            ?: return

        dao.deleteKnowledge(knowledge)
    }
}