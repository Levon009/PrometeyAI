package com.xxlionxx.prometey.presentation

import androidx.lifecycle.viewModelScope
import com.xxlionxx.prometey.domain.model.AIMessageContext
import com.xxlionxx.prometey.domain.model.Attachment
import com.xxlionxx.prometey.domain.model.AttachmentType
import com.xxlionxx.prometey.domain.model.Conversation
import com.xxlionxx.prometey.domain.model.Message
import com.xxlionxx.prometey.domain.model.MessageRole
import com.xxlionxx.prometey.presentation.events.ChatEvent
import com.xxlionxx.prometey.presentation.states.ChatState
import kotlinx.coroutines.launch

class ChatViewModel(
    private val dependencies: ChatViewModelDependencies
) : MviViewModel<ChatEvent, ChatState>(ChatState()) {

    override fun onEvent(event: ChatEvent) {
        when (event) {
            is ChatEvent.LoadConversations -> {
                loadConversations(event.userId)
            }

            is ChatEvent.LoadConversation -> {
                loadConversation(event.conversationId)
            }

            is ChatEvent.SaveConversation -> {
                saveConversation(event.conversation)
            }

            is ChatEvent.UpdateConversation -> {
                updateConversation(event.conversation)
            }

            is ChatEvent.DeleteConversation -> {
                deleteConversation(event.conversationId)
            }

            is ChatEvent.LoadMessages -> {
                loadMessages(event.conversationId)
            }

            is ChatEvent.LoadMessage -> {
                loadMessage(event.messageId)
            }

            is ChatEvent.SendMessage -> {
                sendMessage(event.content)
            }

            is ChatEvent.SaveMessage -> {
                saveMessage(event.message)
            }

            is ChatEvent.UpdateMessage -> {
                updateMessage(event.message)
            }

            is ChatEvent.DeleteMessage -> {
                deleteMessage(event.messageId)
            }

            is ChatEvent.RetryMessage -> {
                retryMessage(event.messageId)
            }

            is ChatEvent.LoadAttachments -> {
                loadAttachments(event.messageId)
            }

            is ChatEvent.SaveAttachment -> {
                saveAttachment(event.attachment)
            }

            is ChatEvent.DeleteAttachment -> {
                deleteAttachment(event.attachmentId)
            }

            is ChatEvent.AddImages -> {
                addImages(event.imageUris)
            }

            ChatEvent.ClearConversation -> {
                updateState {
                    ChatState()
                }
            }
        }
    }

    private fun loadConversations(userId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val conversations =
                    dependencies.getConversations(userId)

                updateState {
                    it.copy(
                        conversations = conversations,
                        isLoading = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isLoading = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun loadConversation(conversationId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val conversation =
                    dependencies.getConversationById(conversationId)
                        ?: throw IllegalStateException(
                            "Conversation not found"
                        )

                val messages =
                    dependencies.getMessages(conversationId)

                updateState {
                    it.copy(
                        selectedConversation = conversation,
                        messages = messages,
                        isLoading = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isLoading = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun saveConversation(conversation: Conversation) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                dependencies.saveConversation(conversation)

                updateState {
                    it.copy(
                        conversations = it.conversations + conversation,
                        selectedConversation = conversation,
                        isSaving = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isSaving = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun updateConversation(conversation: Conversation) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                dependencies.updateConversation(conversation)

                updateState {
                    it.copy(
                        conversations = it.conversations.map { existing ->
                            if (existing.id == conversation.id) {
                                conversation
                            } else {
                                existing
                            }
                        },
                        selectedConversation =
                            if (it.selectedConversation?.id == conversation.id) {
                                conversation
                            } else {
                                it.selectedConversation
                            },
                        isSaving = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isSaving = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun deleteConversation(conversationId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isDeleting = true,
                    error = null
                )
            }

            try {
                dependencies.deleteConversation(conversationId)

                updateState {
                    it.copy(
                        conversations = it.conversations.filterNot {
                            it.id == conversationId
                        },
                        selectedConversation =
                            if (it.selectedConversation?.id == conversationId) {
                                null
                            } else {
                                it.selectedConversation
                            },
                        messages =
                            if (it.selectedConversation?.id == conversationId) {
                                emptyList()
                            } else {
                                it.messages
                            },
                        isDeleting = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isDeleting = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun loadMessages(conversationId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val messages =
                    dependencies.getMessages(conversationId)

                updateState {
                    it.copy(
                        messages = messages,
                        isLoading = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isLoading = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun loadMessage(messageId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val message =
                    dependencies.getMessageById(messageId)

                updateState {
                    it.copy(
                        selectedMessage = message,
                        isLoading = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isLoading = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun sendMessage(content: String) {
        val trimmedContent = content.trim()

        if (
            trimmedContent.isEmpty() &&
            state.value.pendingImageUris.isEmpty()
        ) {
            return
        }

        if (state.value.isSending) {
            return
        }

        updateState {
            it.copy(
                isSending = true,
                error = null
            )
        }

        viewModelScope.launch {

            try {
                val conversation = state.value.selectedConversation
                    ?: throw IllegalStateException(
                        "A conversation must be selected before sending a message"
                    )

                val conversationId = conversation.id

                val userProfile = dependencies.getUserProfile(conversation.userId)
                    ?: throw IllegalStateException("User profile not found")

                val memories = dependencies.getMemories(conversation.userId)
                val goals = dependencies.getUserGoals(conversation.userId)
                val preferences =
                    dependencies.getUserPreferences(conversation.userId)

                val pendingImages = state.value.pendingImageUris

                val userMessage = Message(
                    id = java.util.UUID.randomUUID().toString(),
                    conversationId = conversationId,
                    role = MessageRole.USER,
                    content = trimmedContent,
                    attachments = emptyList(),
                    createdAt = System.currentTimeMillis()
                )

                dependencies.saveMessage(userMessage)

                val imageAttachments = pendingImages.map { imageUri ->
                    Attachment(
                        id = java.util.UUID.randomUUID().toString(),
                        messageId = userMessage.id,
                        type = AttachmentType.IMAGE,
                        uri = imageUri
                    )
                }

                imageAttachments.forEach { attachment ->
                    dependencies.saveAttachment(attachment)
                }

                val updatedMessages =
                    if (
                        state.value.messages.any {
                            it.id == userMessage.id
                        }
                    ) {
                        state.value.messages
                    } else {
                        state.value.messages + userMessage
                    }

                updateState {
                    it.copy(
                        messages = updatedMessages,
                        attachments = it.attachments + imageAttachments,
                        pendingImageUris = emptyList()
                    )
                }

                val context = AIMessageContext(
                    conversation = conversation,
                    message = updatedMessages,
                    memories = memories,
                    userProfile = userProfile,
                    goals = goals,
                    preferences = preferences
                )

                val response = if (pendingImages.isNotEmpty()) {
                    dependencies.analyzeImages(
                        context = context,
                        imageUris = pendingImages
                    )
                } else {
                    dependencies.generateAIResponse(context)
                }

                val assistantMessage = Message(
                    id = java.util.UUID.randomUUID().toString(),
                    conversationId = conversationId,
                    role = MessageRole.ASSISTANT,
                    content = response.content,
                    attachments = emptyList(),
                    createdAt = response.createdAt
                )

                dependencies.saveMessage(assistantMessage)

                updateState {
                    it.copy(
                        messages =
                            if (
                                it.messages.any {
                                    it.id == assistantMessage.id
                                }
                            ) {
                                it.messages
                            } else {
                                it.messages + assistantMessage
                            },
                        isSending = false,
                        error = null
                    )
                }

            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isSending = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun saveMessage(message: Message) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                dependencies.saveMessage(message)

                updateState {
                    it.copy(
                        messages =
                            if (
                                it.messages.any {
                                    it.id == message.id
                                }
                            ) {
                                it.messages
                            } else {
                                it.messages + message
                            },
                        selectedMessage = message,
                        isSaving = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isSaving = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun updateMessage(message: Message) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                dependencies.updateMessage(message)

                updateState {
                    it.copy(
                        messages = it.messages.map { existing ->
                            if (existing.id == message.id) {
                                message
                            } else {
                                existing
                            }
                        },
                        selectedMessage =
                            if (it.selectedMessage?.id == message.id) {
                                message
                            } else {
                                it.selectedMessage
                            },
                        isSaving = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isSaving = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun deleteMessage(messageId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isDeleting = true,
                    error = null
                )
            }

            try {
                dependencies.deleteMessage(messageId)

                updateState {
                    it.copy(
                        messages = it.messages.filterNot {
                            it.id == messageId
                        },
                        selectedMessage =
                            if (it.selectedMessage?.id == messageId) {
                                null
                            } else {
                                it.selectedMessage
                            },
                        isDeleting = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isDeleting = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun retryMessage(messageId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSending = true,
                    error = null
                )
            }

            try {
                val message = state.value.messages
                    .firstOrNull { it.id == messageId }
                    ?: throw IllegalStateException(
                        "Message not found"
                    )

                if (message.role != MessageRole.USER) {
                    throw IllegalArgumentException(
                        "Only user messages can be retried"
                    )
                }

                val conversation = state.value.selectedConversation
                    ?: throw IllegalStateException(
                        "A conversation must be selected before retrying a message"
                    )

                if (message.conversationId != conversation.id) {
                    throw IllegalStateException(
                        "Message does not belong to the selected conversation"
                    )
                }

                val userProfile = dependencies.getUserProfile(conversation.userId)
                    ?: throw IllegalStateException("User profile not found")

                val memories = dependencies.getMemories(conversation.userId)
                val goals = dependencies.getUserGoals(conversation.userId)
                val preferences =
                    dependencies.getUserPreferences(conversation.userId)

                val attachments =
                    dependencies.getAttachments(message.id)

                val imageUris = attachments
                    .filter { it.type == AttachmentType.IMAGE }
                    .map { it.uri }

                val context = AIMessageContext(
                    conversation = conversation,
                    message = state.value.messages,
                    memories = memories,
                    userProfile = userProfile,
                    goals = goals,
                    preferences = preferences
                )

                val response = if (imageUris.isNotEmpty()) {
                    dependencies.analyzeImages(
                        context = context,
                        imageUris = imageUris
                    )
                } else {
                    dependencies.generateAIResponse(context)
                }

                val assistantMessage = Message(
                    id = java.util.UUID.randomUUID().toString(),
                    conversationId = conversation.id,
                    role = MessageRole.ASSISTANT,
                    content = response.content,
                    attachments = emptyList(),
                    createdAt = response.createdAt
                )

                dependencies.saveMessage(assistantMessage)

                updateState {
                    it.copy(
                        messages = it.messages + assistantMessage,
                        attachments = it.attachments
                            .filterNot { existing ->
                                existing.messageId == message.id
                            } + attachments,
                        isSending = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isSending = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun loadAttachments(messageId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                val attachments =
                    dependencies.getAttachments(messageId)

                updateState {
                    it.copy(
                        attachments = attachments,
                        isLoading = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isLoading = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun saveAttachment(attachment: Attachment) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isSaving = true,
                    error = null
                )
            }

            try {
                dependencies.saveAttachment(attachment)

                updateState {
                    it.copy(
                        attachments = it.attachments + attachment,
                        isSaving = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isSaving = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun deleteAttachment(attachmentId: String) {
        viewModelScope.launch {
            updateState {
                it.copy(
                    isDeleting = true,
                    error = null
                )
            }

            try {
                dependencies.deleteAttachment(attachmentId)

                updateState {
                    it.copy(
                        attachments = it.attachments.filterNot {
                            it.id == attachmentId
                        },
                        isDeleting = false,
                        error = null
                    )
                }
            } catch (exception: Exception) {
                updateState {
                    it.copy(
                        isDeleting = false,
                        error = exception.message
                    )
                }
            }
        }
    }

    private fun addImages(imageUris: List<String>) {
        if (imageUris.isEmpty()) {
            return
        }

        updateState {
            it.copy(
                pendingImageUris =
                    it.pendingImageUris + imageUris
            )
        }
    }
}