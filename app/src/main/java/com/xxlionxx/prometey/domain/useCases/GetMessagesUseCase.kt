package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.Message
import com.xxlionxx.prometey.domain.repository.MessageRepository

class GetMessagesUseCase(
    private val messageRepository: MessageRepository
) {

    suspend operator fun invoke(conversationId: String): List<Message> {
        return messageRepository.getMessages(conversationId)
    }
}