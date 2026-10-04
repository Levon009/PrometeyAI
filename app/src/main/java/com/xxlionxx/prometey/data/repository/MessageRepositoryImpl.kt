package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.MessageDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.Message
import com.xxlionxx.prometey.domain.repository.AttachmentRepository
import com.xxlionxx.prometey.domain.repository.MessageRepository

class MessageRepositoryImpl(
    private val dao: MessageDao,
    private val attachmentRepository: AttachmentRepository
) : MessageRepository {

    override suspend fun getMessages(
        conversationId: String
    ): List<Message> {
        return dao.getMessages(conversationId).map { message ->
            message.toDomain(
                attachments = attachmentRepository.getAttachments(message.id)
            )
        }
    }

    override suspend fun getMessageById(
        id: String
    ): Message? {
        val message = dao.getMessageById(id)
            ?: return null

        return message.toDomain(
            attachments = attachmentRepository.getAttachments(message.id)
        )
    }

    override suspend fun saveMessage(
        message: Message
    ) {
        dao.insertMessage(
            message.toEntity()
        )
    }

    override suspend fun updateMessage(
        message: Message
    ) {
        dao.updateMessage(
            message.toEntity()
        )
    }

    override suspend fun deleteMessage(
        id: String
    ) {
        val message = dao.getMessageById(id)
            ?: return

        dao.deleteMessage(message)
    }
}