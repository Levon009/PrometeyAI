package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.repository.MessageRepository

class DeleteMessageUseCase(
    private val messageRepository: MessageRepository
) {

    suspend operator fun invoke(id: String) {
        messageRepository.deleteMessage(id)
    }
}