package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.Message
import com.xxlionxx.prometey.domain.repository.MessageRepository

class GetMessageByIdUseCase(
    private val messageRepository: MessageRepository
) {

    suspend operator fun invoke(id: String): Message? {
        return messageRepository.getMessageById(id)
    }
}