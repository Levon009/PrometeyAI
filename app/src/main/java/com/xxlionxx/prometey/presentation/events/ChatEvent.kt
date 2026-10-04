package com.xxlionxx.prometey.presentation.events

import com.xxlionxx.prometey.domain.model.Attachment
import com.xxlionxx.prometey.domain.model.Conversation
import com.xxlionxx.prometey.domain.model.Message

sealed interface ChatEvent : MviEvent {

    data class LoadConversations(
        val userId: String
    ) : ChatEvent

    data class LoadConversation(
        val conversationId: String
    ) : ChatEvent

    data class SaveConversation(
        val conversation: Conversation
    ) : ChatEvent

    data class UpdateConversation(
        val conversation: Conversation
    ) : ChatEvent

    data class DeleteConversation(
        val conversationId: String
    ) : ChatEvent

    data class LoadMessages(
        val conversationId: String
    ) : ChatEvent

    data class LoadMessage(
        val messageId: String
    ) : ChatEvent

    data class SendMessage(
        val content: String
    ) : ChatEvent

    data class SaveMessage(
        val message: Message
    ) : ChatEvent

    data class UpdateMessage(
        val message: Message
    ) : ChatEvent

    data class DeleteMessage(
        val messageId: String
    ) : ChatEvent

    data class RetryMessage(
        val messageId: String
    ) : ChatEvent

    data class LoadAttachments(
        val messageId: String
    ) : ChatEvent

    data class SaveAttachment(
        val attachment: Attachment
    ) : ChatEvent

    data class DeleteAttachment(
        val attachmentId: String
    ) : ChatEvent

    data class AddImages(
        val imageUris: List<String>
    ) : ChatEvent

    data object ClearConversation : ChatEvent
}