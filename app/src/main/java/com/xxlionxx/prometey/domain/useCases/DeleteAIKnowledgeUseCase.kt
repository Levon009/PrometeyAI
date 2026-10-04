package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.AIKnowledgeRepository

class DeleteAIKnowledgeUseCase(
    private val aiKnowledgeRepository: AIKnowledgeRepository
) {

    suspend operator fun invoke(id: String) {
        aiKnowledgeRepository.deleteKnowledge(id)
    }
}