package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.Conversation
import com.xxlionxx.prometey.domain.repository.ConversationRepository

class GetConversationByIdUseCase(
    private val conversationRepository: ConversationRepository
) {

    suspend operator fun invoke(id: String): Conversation? {
        return conversationRepository.getConversationById(id)
    }
}