package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.AIKnowledge
import com.xxlionxx.prometey.domain.repository.AIKnowledgeRepository

class GetAIKnowledgeByIdUseCase(
    private val aiKnowledgeRepository: AIKnowledgeRepository
) {

    suspend operator fun invoke(id: String): AIKnowledge? {
        return aiKnowledgeRepository.getKnowledgeById(id)
    }
}