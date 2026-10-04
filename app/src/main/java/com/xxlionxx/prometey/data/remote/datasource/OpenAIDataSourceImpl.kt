package com.xxlionxx.prometey.data.remote.datasource

import com.xxlionxx.prometey.data.remote.api.OpenAIApi
import com.xxlionxx.prometey.data.remote.dto.OpenAIImageRequestDto
import com.xxlionxx.prometey.data.remote.dto.OpenAIRequestDto
import com.xxlionxx.prometey.data.remote.dto.OpenAIResponseDto

class OpenAIDataSourceImpl(
    private val api: OpenAIApi
) : OpenAIDataSource {

    override suspend fun generateResponse(
        request: OpenAIRequestDto
    ): OpenAIResponseDto {
        return api.generateResponse(request)
    }

    override suspend fun analyzeImages(
        request: OpenAIImageRequestDto
    ): OpenAIResponseDto {
        return api.analyzeImages(request)
    }
}