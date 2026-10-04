package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.ConversationRepository

class DeleteConversationUseCase(
    private val conversationRepository: ConversationRepository
) {

    suspend operator fun invoke(id: String) {
        conversationRepository.deleteConversation(id)
    }
}