package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.Message

interface MessageRepository {

    suspend fun getMessages(conversationId: String): List<Message>

    suspend fun getMessageById(id: String): Message?

    suspend fun saveMessage(message: Message)

    suspend fun updateMessage(message: Message)

    suspend fun deleteMessage(id: String)
}