package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.remote.LocalImageDataUrlProvider
import com.xxlionxx.prometey.data.remote.datasource.OpenAIDataSource
import com.xxlionxx.prometey.data.remote.mapper.toDomainResponse
import com.xxlionxx.prometey.data.remote.mapper.toOpenAIImageRequest
import com.xxlionxx.prometey.domain.model.AIMessageContext
import com.xxlionxx.prometey.domain.model.AIResponse
import com.xxlionxx.prometey.domain.repository.AIImageRepository

class AIImageRepositoryImpl(
    private val openAIDataSource: OpenAIDataSource,
    private val localImageDataUrlProvider: LocalImageDataUrlProvider
) : AIImageRepository {

    override suspend fun analyzeImages(
        context: AIMessageContext,
        imageUris: List<String>
    ): AIResponse {

        val imageDataUrls = imageUris.map { imageUri ->
            localImageDataUrlProvider.provide(imageUri)
        }

        val request = context.toOpenAIImageRequest(
            imageUris = imageDataUrls,
            model = "gpt-5"
        )

        val response = openAIDataSource.analyzeImages(request)

        return response.toDomainResponse()
    }
}