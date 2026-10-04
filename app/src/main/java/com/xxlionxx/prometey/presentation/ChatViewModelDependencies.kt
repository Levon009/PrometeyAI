package com.xxlionxx.prometey.presentation

import com.xxlionxx.prometey.domain.useCases.AnalyzeImagesUseCase
import com.xxlionxx.prometey.domain.useCases.DeleteAttachmentUseCase
import com.xxlionxx.prometey.domain.useCases.DeleteConversationUseCase
import com.xxlionxx.prometey.domain.useCases.DeleteMessageUseCase
import com.xxlionxx.prometey.domain.useCases.GenerateAIResponseUseCase
import com.xxlionxx.prometey.domain.useCases.GetAttachmentsUseCase
import com.xxlionxx.prometey.domain.useCases.GetConversationByIdUseCase
import com.xxlionxx.prometey.domain.useCases.GetConversationsUseCase
import com.xxlionxx.prometey.domain.useCases.GetMemoriesUseCase
import com.xxlionxx.prometey.domain.useCases.GetMessageByIdUseCase
import com.xxlionxx.prometey.domain.useCases.GetMessagesUseCase
import com.xxlionxx.prometey.domain.useCases.GetUserGoalsUseCase
import com.xxlionxx.prometey.domain.useCases.GetUserPreferencesUseCase
import com.xxlionxx.prometey.domain.useCases.GetUserProfileUseCase
import com.xxlionxx.prometey.domain.useCases.SaveAttachmentUseCase
import com.xxlionxx.prometey.domain.useCases.SaveConversationUseCase
import com.xxlionxx.prometey.domain.useCases.SaveMessageUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateConversationUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateMessageUseCase

data class ChatViewModelDependencies(
    val getConversations: GetConversationsUseCase,
    val getConversationById: GetConversationByIdUseCase,
    val saveConversation: SaveConversationUseCase,
    val updateConversation: UpdateConversationUseCase,
    val deleteConversation: DeleteConversationUseCase,

    val getMessages: GetMessagesUseCase,
    val getMessageById: GetMessageByIdUseCase,
    val saveMessage: SaveMessageUseCase,
    val updateMessage: UpdateMessageUseCase,
    val deleteMessage: DeleteMessageUseCase,

    val getAttachments: GetAttachmentsUseCase,
    val saveAttachment: SaveAttachmentUseCase,
    val deleteAttachment: DeleteAttachmentUseCase,

    val generateAIResponse: GenerateAIResponseUseCase,
    val analyzeImages: AnalyzeImagesUseCase,

    val getMemories: GetMemoriesUseCase,
    val getUserProfile: GetUserProfileUseCase,
    val getUserGoals: GetUserGoalsUseCase,
    val getUserPreferences: GetUserPreferencesUseCase
)