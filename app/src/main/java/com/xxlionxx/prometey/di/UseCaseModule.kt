package com.xxlionxx.prometey.di

import com.xxlionxx.prometey.domain.useCases.DeleteAttachmentUseCase
import com.xxlionxx.prometey.domain.useCases.DeleteConversationUseCase
import com.xxlionxx.prometey.domain.useCases.DeleteMessageUseCase
import com.xxlionxx.prometey.domain.useCases.GetAttachmentsUseCase
import com.xxlionxx.prometey.domain.useCases.GetConversationsUseCase
import com.xxlionxx.prometey.domain.useCases.GetMessageByIdUseCase
import com.xxlionxx.prometey.domain.useCases.SaveAttachmentUseCase
import com.xxlionxx.prometey.domain.useCases.SaveConversationUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateConversationUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateMessageUseCase
import com.xxlionxx.prometey.domain.useCases.AnalyzeImagesUseCase
import com.xxlionxx.prometey.domain.useCases.GenerateAIResponseUseCase
import com.xxlionxx.prometey.domain.useCases.GetConversationByIdUseCase
import com.xxlionxx.prometey.domain.useCases.GetMemoriesUseCase
import com.xxlionxx.prometey.domain.useCases.GetMessagesUseCase
import com.xxlionxx.prometey.domain.useCases.GetUserGoalsUseCase
import com.xxlionxx.prometey.domain.useCases.GetUserPreferencesUseCase
import com.xxlionxx.prometey.domain.useCases.GetUserProfileUseCase
import com.xxlionxx.prometey.domain.useCases.SaveMessageUseCase
import org.koin.dsl.module
import com.xxlionxx.prometey.domain.useCases.DeleteMemoryUseCase
import com.xxlionxx.prometey.domain.useCases.GetMemoryByIdUseCase
import com.xxlionxx.prometey.domain.useCases.SaveMemoryUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateMemoryUseCase
import com.xxlionxx.prometey.domain.useCases.GetUserByIdUseCase
import com.xxlionxx.prometey.domain.useCases.SaveUserUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateUserUseCase
import com.xxlionxx.prometey.domain.useCases.SaveUserProfileUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateUserProfileUseCase
import com.xxlionxx.prometey.domain.useCases.DeleteUserGoalUseCase
import com.xxlionxx.prometey.domain.useCases.GetUserGoalByIdUseCase
import com.xxlionxx.prometey.domain.useCases.SaveUserGoalUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateUserGoalUseCase
import com.xxlionxx.prometey.domain.useCases.DeleteUserPreferenceUseCase
import com.xxlionxx.prometey.domain.useCases.GetUserPreferenceByKeyUseCase
import com.xxlionxx.prometey.domain.useCases.SaveUserPreferenceUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateUserPreferenceUseCase
import com.xxlionxx.prometey.domain.useCases.ContainsSecureValueUseCase
import com.xxlionxx.prometey.domain.useCases.DeleteSecureValueUseCase
import com.xxlionxx.prometey.domain.useCases.GetAISettingsUseCase
import com.xxlionxx.prometey.domain.useCases.GetAppSettingBooleanUseCase
import com.xxlionxx.prometey.domain.useCases.GetAppSettingStringUseCase
import com.xxlionxx.prometey.domain.useCases.GetSecureValueUseCase
import com.xxlionxx.prometey.domain.useCases.RemoveAppSettingUseCase
import com.xxlionxx.prometey.domain.useCases.SaveAISettingsUseCase
import com.xxlionxx.prometey.domain.useCases.SaveSecureValueUseCase
import com.xxlionxx.prometey.domain.useCases.SetAppSettingBooleanUseCase
import com.xxlionxx.prometey.domain.useCases.SetAppSettingStringUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateAISettingsUseCase
import com.xxlionxx.prometey.domain.useCases.DeleteAIInstructionUseCase
import com.xxlionxx.prometey.domain.useCases.DeleteAIKnowledgeUseCase
import com.xxlionxx.prometey.domain.useCases.ExecuteAIActionUseCase
import com.xxlionxx.prometey.domain.useCases.GetAIActionPermissionUseCase
import com.xxlionxx.prometey.domain.useCases.GetAIActionPolicyUseCase
import com.xxlionxx.prometey.domain.useCases.GetAIBehaviorUseCase
import com.xxlionxx.prometey.domain.useCases.GetAIKnowledgeByIdUseCase
import com.xxlionxx.prometey.domain.useCases.GetAIKnowledgeUseCase
import com.xxlionxx.prometey.domain.useCases.GetAIModelByIdUseCase
import com.xxlionxx.prometey.domain.useCases.GetActiveAIInstructionsUseCase
import com.xxlionxx.prometey.domain.useCases.GetAvailableAIModelsUseCase
import com.xxlionxx.prometey.domain.useCases.SaveAIActionPolicyUseCase
import com.xxlionxx.prometey.domain.useCases.SaveAIBehaviorUseCase
import com.xxlionxx.prometey.domain.useCases.SaveAIInstructionUseCase
import com.xxlionxx.prometey.domain.useCases.SaveAIKnowledgeUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateAIActionPolicyUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateAIBehaviorUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateAIInstructionUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateAIKnowledgeUseCase
import com.xxlionxx.prometey.domain.useCases.DeleteForecastFactorSourceUseCase
import com.xxlionxx.prometey.domain.useCases.DeleteForecastFactorUseCase
import com.xxlionxx.prometey.domain.useCases.DeleteForecastScenarioUseCase
import com.xxlionxx.prometey.domain.useCases.DeleteForecastSourceUseCase
import com.xxlionxx.prometey.domain.useCases.DeleteForecastUseCase
import com.xxlionxx.prometey.domain.useCases.GetForecastByIdUseCase
import com.xxlionxx.prometey.domain.useCases.GetForecastDataSourcesUseCase
import com.xxlionxx.prometey.domain.useCases.GetForecastFactorSourcesUseCase
import com.xxlionxx.prometey.domain.useCases.GetForecastFactorsUseCase
import com.xxlionxx.prometey.domain.useCases.GetForecastRecommendationsUseCase
import com.xxlionxx.prometey.domain.useCases.GetForecastScenariosUseCase
import com.xxlionxx.prometey.domain.useCases.GetForecastSourceByIdUseCase
import com.xxlionxx.prometey.domain.useCases.GetForecastsUseCase
import com.xxlionxx.prometey.domain.useCases.SaveForecastFactorSourceUseCase
import com.xxlionxx.prometey.domain.useCases.SaveForecastFactorUseCase
import com.xxlionxx.prometey.domain.useCases.SaveForecastRecommendationUseCase
import com.xxlionxx.prometey.domain.useCases.SaveForecastScenarioUseCase
import com.xxlionxx.prometey.domain.useCases.SaveForecastSourceUseCase
import com.xxlionxx.prometey.domain.useCases.SaveForecastUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateForecastFactorUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateForecastRecommendationUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateForecastScenarioUseCase
import com.xxlionxx.prometey.domain.useCases.UpdateForecastUseCase
import com.xxlionxx.prometey.data.user.CurrentUserManager
import com.xxlionxx.prometey.ui.theme.ThemeManager

val useCaseModule = module {

    factory {
        GetConversationByIdUseCase(
            conversationRepository = get()
        )
    }

    factory {
        GetConversationsUseCase(
            conversationRepository = get()
        )
    }

    factory {
        SaveConversationUseCase(
            conversationRepository = get()
        )
    }

    factory {
        UpdateConversationUseCase(
            conversationRepository = get()
        )
    }

    factory {
        DeleteConversationUseCase(
            conversationRepository = get()
        )
    }

    factory {
        GetMessagesUseCase(
            messageRepository = get()
        )
    }

    factory {
        SaveMessageUseCase(
            messageRepository = get()
        )
    }

    factory {
        GetMessageByIdUseCase(
            messageRepository = get()
        )
    }

    factory {
        UpdateMessageUseCase(
            messageRepository = get()
        )
    }

    factory {
        DeleteMessageUseCase(
            messageRepository = get()
        )
    }

    factory {
        GetAttachmentsUseCase(
            attachmentRepository = get()
        )
    }

    factory {
        SaveAttachmentUseCase(
            attachmentRepository = get()
        )
    }

    factory {
        DeleteAttachmentUseCase(
            attachmentRepository = get()
        )
    }

    factory {
        GenerateAIResponseUseCase(
            aiRepository = get()
        )
    }

    factory {
        AnalyzeImagesUseCase(
            aiImageRepository = get()
        )
    }

    factory {
        GetMemoriesUseCase(
            memoryRepository = get()
        )
    }

    factory {
        GetUserProfileUseCase(
            userProfileRepository = get()
        )
    }

    factory {
        GetUserGoalsUseCase(
            userGoalRepository = get()
        )
    }

    factory {
        GetUserPreferencesUseCase(
            userPreferenceRepository = get()
        )
    }

    factory {
        GetMemoryByIdUseCase(
            memoryRepository = get()
        )
    }

    factory {
        SaveMemoryUseCase(
            memoryRepository = get()
        )
    }

    factory {
        UpdateMemoryUseCase(
            memoryRepository = get()
        )
    }

    factory {
        DeleteMemoryUseCase(
            memoryRepository = get()
        )
    }

    factory {
        GetUserByIdUseCase(
            userRepository = get()
        )
    }

    factory {
        SaveUserUseCase(
            userRepository = get()
        )
    }

    factory {
        UpdateUserUseCase(
            userRepository = get()
        )
    }

    factory {
        SaveUserProfileUseCase(
            userProfileRepository = get()
        )
    }

    factory {
        UpdateUserProfileUseCase(
            userProfileRepository = get()
        )
    }

    factory {
        GetUserGoalByIdUseCase(
            userGoalRepository = get()
        )
    }

    factory {
        SaveUserGoalUseCase(
            userGoalRepository = get()
        )
    }

    factory {
        UpdateUserGoalUseCase(
            userGoalRepository = get()
        )
    }

    factory {
        DeleteUserGoalUseCase(
            userGoalRepository = get()
        )
    }

    factory {
        GetUserPreferenceByKeyUseCase(
            userPreferenceRepository = get()
        )
    }

    factory {
        SaveUserPreferenceUseCase(
            userPreferenceRepository = get()
        )
    }

    factory {
        UpdateUserPreferenceUseCase(
            userPreferenceRepository = get()
        )
    }

    factory {
        DeleteUserPreferenceUseCase(
            userPreferenceRepository = get()
        )
    }

    factory { GetAISettingsUseCase(get()) }
    factory { SaveAISettingsUseCase(get()) }
    factory { UpdateAISettingsUseCase(get()) }

    factory { GetAppSettingBooleanUseCase(get()) }
    factory { GetAppSettingStringUseCase(get()) }
    factory { SetAppSettingBooleanUseCase(get()) }
    factory { SetAppSettingStringUseCase(get()) }
    factory { RemoveAppSettingUseCase(get()) }

    factory { ContainsSecureValueUseCase(get()) }
    factory { GetSecureValueUseCase(get()) }
    factory { SaveSecureValueUseCase(get()) }
    factory { DeleteSecureValueUseCase(get()) }

    factory { GetAIBehaviorUseCase(get()) }
    factory { SaveAIBehaviorUseCase(get()) }
    factory { UpdateAIBehaviorUseCase(get()) }

    factory { GetActiveAIInstructionsUseCase(get()) }
    factory { SaveAIInstructionUseCase(get()) }
    factory { UpdateAIInstructionUseCase(get()) }
    factory { DeleteAIInstructionUseCase(get()) }

    factory { GetAIKnowledgeUseCase(get()) }
    factory { GetAIKnowledgeByIdUseCase(get()) }
    factory { SaveAIKnowledgeUseCase(get()) }
    factory { UpdateAIKnowledgeUseCase(get()) }
    factory { DeleteAIKnowledgeUseCase(get()) }

    factory { GetAvailableAIModelsUseCase(get()) }
    factory { GetAIModelByIdUseCase(get()) }

    factory { GetAISettingsUseCase(get()) }
    factory { SaveAISettingsUseCase(get()) }
    factory { UpdateAISettingsUseCase(get()) }

    factory { GetAIActionPolicyUseCase(get()) }
    factory { SaveAIActionPolicyUseCase(get()) }
    factory { UpdateAIActionPolicyUseCase(get()) }

    factory { GetAIActionPermissionUseCase(get()) }
    factory { ExecuteAIActionUseCase(get()) }

    factory { GetForecastsUseCase(get()) }
    factory { GetForecastByIdUseCase(get()) }
    factory { SaveForecastUseCase(get()) }
    factory { UpdateForecastUseCase(get()) }
    factory { DeleteForecastUseCase(get()) }

    factory { GetForecastFactorsUseCase(get()) }
    factory { SaveForecastFactorUseCase(get()) }
    factory { UpdateForecastFactorUseCase(get()) }
    factory { DeleteForecastFactorUseCase(get()) }

    factory { GetForecastFactorSourcesUseCase(get()) }
    factory { SaveForecastFactorSourceUseCase(get()) }
    factory { DeleteForecastFactorSourceUseCase(get()) }

    factory { GetForecastRecommendationsUseCase(get()) }
    factory { SaveForecastRecommendationUseCase(get()) }
    factory { UpdateForecastRecommendationUseCase(get()) }

    factory { GetForecastScenariosUseCase(get()) }
    factory { SaveForecastScenarioUseCase(get()) }
    factory { UpdateForecastScenarioUseCase(get()) }
    factory { DeleteForecastScenarioUseCase(get()) }

    factory { GetForecastSourceByIdUseCase(get()) }
    factory { SaveForecastSourceUseCase(get()) }
    factory { DeleteForecastSourceUseCase(get()) }

    factory { GetForecastDataSourcesUseCase(get()) }

    single {
        CurrentUserManager(
            appSettingsRepository = get()
        )
    }

    single {
        ThemeManager(
            getAppSettingStringUseCase = get(),
            setAppSettingStringUseCase = get()
        )
    }
}