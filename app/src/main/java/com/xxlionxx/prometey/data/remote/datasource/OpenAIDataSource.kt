package com.xxlionxx.prometey.data.remote.datasource

import com.xxlionxx.prometey.data.remote.dto.OpenAIImageRequestDto
import com.xxlionxx.prometey.data.remote.dto.OpenAIRequestDto
import com.xxlionxx.prometey.data.remote.dto.OpenAIResponseDto

interface OpenAIDataSource {

    suspend fun generateResponse(
        request: OpenAIRequestDto
    ): OpenAIResponseDto

    suspend fun analyzeImages(
        request: OpenAIImageRequestDto
    ): OpenAIResponseDto
}