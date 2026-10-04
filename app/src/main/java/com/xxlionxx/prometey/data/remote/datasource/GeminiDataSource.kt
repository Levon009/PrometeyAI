package com.xxlionxx.prometey.data.remote.datasource

import com.xxlionxx.prometey.data.remote.dto.GeminiRequestDto
import com.xxlionxx.prometey.data.remote.dto.GeminiResponseDto

interface GeminiDataSource {

    suspend fun generateResponse(
        request: GeminiRequestDto
    ): GeminiResponseDto
}