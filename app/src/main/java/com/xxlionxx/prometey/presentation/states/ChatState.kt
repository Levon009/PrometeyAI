package com.xxlionxx.prometey.presentation.states

import com.xxlionxx.prometey.domain.model.Attachment
import com.xxlionxx.prometey.domain.model.Conversation
import com.xxlionxx.prometey.domain.model.Message

data class ChatState(
    val conversations: List<Conversation> = emptyList(),
    val selectedConversation: Conversation? = null,
    val messages: List<Message> = emptyList(),
    val selectedMessage: Message? = null,
    val attachments: List<Attachment> = emptyList(),
    val isLoading: Boolean = false,
    val isSending: Boolean = false,
    val isSaving: Boolean = false,
    val isDeleting: Boolean = false,
    val error: String? = null,
    val pendingImageUris: List<String> = emptyList()
) : MviState