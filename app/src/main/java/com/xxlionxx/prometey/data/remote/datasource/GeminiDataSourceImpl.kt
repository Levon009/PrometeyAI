package com.xxlionxx.prometey.data.remote.datasource

import com.xxlionxx.prometey.data.remote.api.GeminiApi
import com.xxlionxx.prometey.data.remote.dto.GeminiRequestDto
import com.xxlionxx.prometey.data.remote.dto.GeminiResponseDto

class GeminiDataSourceImpl(
    private val api: GeminiApi
) : GeminiDataSource {

    override suspend fun generateResponse(
        request: GeminiRequestDto
    ): GeminiResponseDto {
        return api.generateResponse(request)
    }
}