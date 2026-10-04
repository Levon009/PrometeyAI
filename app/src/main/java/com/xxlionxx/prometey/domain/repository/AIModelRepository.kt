package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.AIModel

interface AIModelRepository {

    suspend fun getAvailableModels(): List<AIModel>

    suspend fun getModelById(id: String): AIModel?
}