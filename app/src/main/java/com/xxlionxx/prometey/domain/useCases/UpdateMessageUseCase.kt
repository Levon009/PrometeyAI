package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.Message
import com.xxlionxx.prometey.domain.repository.MessageRepository

class UpdateMessageUseCase(
    private val messageRepository: MessageRepository
) {

    suspend operator fun invoke(message: Message) {
        messageRepository.updateMessage(message)
    }
}