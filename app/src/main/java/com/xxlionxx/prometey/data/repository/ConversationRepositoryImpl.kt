package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.ConversationDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.Conversation
import com.xxlionxx.prometey.domain.repository.ConversationRepository

class ConversationRepositoryImpl(
    private val dao: ConversationDao
) : ConversationRepository {

    override suspend fun getConversations(
        userId: String
    ): List<Conversation> {
        return dao.getConversations(userId)
            .map { it.toDomain() }
    }

    override suspend fun getConversationById(
        id: String
    ): Conversation? {
        return dao.getConversationById(id)
            ?.toDomain()
    }

    override suspend fun saveConversation(
        conversation: Conversation
    ) {
        dao.insertConversation(
            conversation.toEntity()
        )
    }

    override suspend fun updateConversation(
        conversation: Conversation
    ) {
        dao.updateConversation(
            conversation.toEntity()
        )
    }

    override suspend fun deleteConversation(
        id: String
    ) {
        val conversation = dao.getConversationById(id)
            ?: return

        dao.deleteConversation(conversation)
    }
}