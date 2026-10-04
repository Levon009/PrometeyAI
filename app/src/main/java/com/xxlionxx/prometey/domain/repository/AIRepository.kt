package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.AIMessageContext
import com.xxlionxx.prometey.domain.model.AIResponse

interface AIRepository {

    suspend fun generateResponse(context: AIMessageContext): AIResponse

}