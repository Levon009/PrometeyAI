package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.AIKnowledge
import com.xxlionxx.prometey.domain.repository.AIKnowledgeRepository

class SaveAIKnowledgeUseCase(
    private val aiKnowledgeRepository: AIKnowledgeRepository
) {

    suspend operator fun invoke(knowledge: AIKnowledge) {
        aiKnowledgeRepository.saveKnowledge(knowledge)
    }
}