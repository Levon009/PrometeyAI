package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.Conversation

interface ConversationRepository {

    suspend fun getConversations(userId: String): List<Conversation>

    suspend fun getConversationById(id: String): Conversation?

    suspend fun saveConversation(conversation: Conversation)

    suspend fun updateConversation(conversation: Conversation)

    suspend fun deleteConversation(id: String)
}