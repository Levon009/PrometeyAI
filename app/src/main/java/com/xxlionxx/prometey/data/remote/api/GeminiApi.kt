package com.xxlionxx.prometey.data.remote.api

import com.xxlionxx.prometey.data.remote.dto.GeminiRequestDto
import com.xxlionxx.prometey.data.remote.dto.GeminiResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface GeminiApi {

    @POST("v1beta/interactions")
    suspend fun generateResponse(
        @Body request: GeminiRequestDto
    ): GeminiResponseDto
}