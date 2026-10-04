package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.Conversation
import com.xxlionxx.prometey.domain.repository.ConversationRepository

class SaveConversationUseCase(
    private val conversationRepository: ConversationRepository
) {

    suspend operator fun invoke(conversation: Conversation) {
        conversationRepository.saveConversation(conversation)
    }
}