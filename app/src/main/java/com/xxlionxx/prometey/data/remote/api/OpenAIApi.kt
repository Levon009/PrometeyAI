package com.xxlionxx.prometey.data.remote.api

import com.xxlionxx.prometey.data.remote.dto.OpenAIImageRequestDto
import com.xxlionxx.prometey.data.remote.dto.OpenAIRequestDto
import com.xxlionxx.prometey.data.remote.dto.OpenAIResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface OpenAIApi {

    @POST("v1/responses")
    suspend fun generateResponse(
        @Body request: OpenAIRequestDto
    ): OpenAIResponseDto

    @POST("v1/responses")
    suspend fun analyzeImages(
        @Body request: OpenAIImageRequestDto
    ): OpenAIResponseDto
}