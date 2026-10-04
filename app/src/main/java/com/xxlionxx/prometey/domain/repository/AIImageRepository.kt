package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.AIMessageContext
import com.xxlionxx.prometey.domain.model.AIResponse

interface AIImageRepository {

    suspend fun analyzeImages(context: AIMessageContext, imageUris: List<String>): AIResponse
}