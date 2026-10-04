package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.Conversation
import com.xxlionxx.prometey.domain.repository.ConversationRepository

class GetConversationsUseCase(
    private val conversationRepository: ConversationRepository
) {

    suspend operator fun invoke(userId: String): List<Conversation> {
        return conversationRepository.getConversations(userId)
    }
}