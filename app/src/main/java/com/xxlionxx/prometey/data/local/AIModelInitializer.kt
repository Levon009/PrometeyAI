package com.xxlionxx.prometey.data.local

import com.xxlionxx.prometey.data.local.dao.AIModelDao
import com.xxlionxx.prometey.data.local.entity.AIModelEntity

class AIModelInitializer(
    private val dao: AIModelDao
) {

    suspend fun initialize() {

        val existingModels = dao.getAvailableModels()
            .associateBy { it.id }

        val models = listOf(
            AIModelEntity(
                id = "gemini-3.8-flash",
                provider = "GEMINI",
                name = "Gemini 3.8 Flash",
                isMultimodal = true
            ),
            AIModelEntity(
                id = "gpt-5",
                provider = "OPENAI",
                name = "GPT-5",
                isMultimodal = true
            )
        )

        models.forEach { model ->

            if (existingModels[model.id] == null) {
                dao.insertModel(model)
            }
        }
    }
}