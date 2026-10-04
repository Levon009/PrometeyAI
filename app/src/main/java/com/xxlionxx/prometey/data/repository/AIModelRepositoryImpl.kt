package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.AIModelDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.domain.model.AIModel
import com.xxlionxx.prometey.domain.repository.AIModelRepository

class AIModelRepositoryImpl(
    private val dao: AIModelDao
) : AIModelRepository {

    override suspend fun getAvailableModels(): List<AIModel> {
        return dao.getAvailableModels()
            .map { it.toDomain() }
    }

    override suspend fun getModelById(
        id: String
    ): AIModel? {
        return dao.getModelById(id)
            ?.toDomain()
    }
}