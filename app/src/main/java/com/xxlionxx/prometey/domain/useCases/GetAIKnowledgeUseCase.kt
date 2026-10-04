package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.AIKnowledge
import com.xxlionxx.prometey.domain.repository.AIKnowledgeRepository

class GetAIKnowledgeUseCase(
    private val aiKnowledgeRepository: AIKnowledgeRepository
) {

    suspend operator fun invoke(topic: String): List<AIKnowledge> {
        return aiKnowledgeRepository.getKnowledge(topic)
    }
}