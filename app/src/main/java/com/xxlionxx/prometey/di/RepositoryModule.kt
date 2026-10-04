package com.xxlionxx.prometey.di

import com.xxlionxx.prometey.data.repository.AIImageRepositoryImpl
import com.xxlionxx.prometey.data.repository.AIRepositoryImpl
import com.xxlionxx.prometey.domain.repository.AIImageRepository
import com.xxlionxx.prometey.domain.repository.AIRepository
import org.koin.dsl.module
import com.xxlionxx.prometey.data.repository.AIActionPolicyRepositoryImpl
import com.xxlionxx.prometey.domain.repository.AIActionPolicyRepository
import com.xxlionxx.prometey.data.repository.AIBehaviorRepositoryImpl
import com.xxlionxx.prometey.domain.repository.AIBehaviorRepository
import com.xxlionxx.prometey.data.repository.AIInstructionRepositoryImpl
import com.xxlionxx.prometey.domain.repository.AIInstructionRepository
import com.xxlionxx.prometey.data.repository.AIKnowledgeRepositoryImpl
import com.xxlionxx.prometey.domain.repository.AIKnowledgeRepository
import com.xxlionxx.prometey.data.repository.AISettingsRepositoryImpl
import com.xxlionxx.prometey.domain.repository.AISettingsRepository
import com.xxlionxx.prometey.data.repository.AppSettingsRepositoryImpl
import com.xxlionxx.prometey.domain.repository.AppSettingsRepository
import com.xxlionxx.prometey.data.repository.AttachmentRepositoryImpl
import com.xxlionxx.prometey.domain.repository.AttachmentRepository
import com.xxlionxx.prometey.data.repository.ConversationRepositoryImpl
import com.xxlionxx.prometey.domain.repository.ConversationRepository
import com.xxlionxx.prometey.data.repository.ForecastDataRepositoryImpl
import com.xxlionxx.prometey.domain.repository.ForecastDataRepository
import com.xxlionxx.prometey.data.repository.ForecastFactorRepositoryImpl
import com.xxlionxx.prometey.domain.repository.ForecastFactorRepository
import com.xxlionxx.prometey.data.repository.ForecastFactorSourceRepositoryImpl
import com.xxlionxx.prometey.domain.repository.ForecastFactorSourceRepository
import com.xxlionxx.prometey.data.repository.ForecastRecommendationRepositoryImpl
import com.xxlionxx.prometey.domain.repository.ForecastRecommendationRepository
import com.xxlionxx.prometey.data.repository.ForecastRepositoryImpl
import com.xxlionxx.prometey.domain.repository.ForecastRepository
import com.xxlionxx.prometey.data.repository.ForecastScenarioRepositoryImpl
import com.xxlionxx.prometey.domain.repository.ForecastScenarioRepository
import com.xxlionxx.prometey.data.repository.ForecastSourceRepositoryImpl
import com.xxlionxx.prometey.domain.repository.ForecastSourceRepository
import com.xxlionxx.prometey.data.repository.MemoryRepositoryImpl
import com.xxlionxx.prometey.domain.repository.MemoryRepository
import com.xxlionxx.prometey.data.repository.MessageRepositoryImpl
import com.xxlionxx.prometey.domain.repository.MessageRepository
import com.xxlionxx.prometey.data.repository.SecureStorageRepositoryImpl
import com.xxlionxx.prometey.domain.repository.SecureStorageRepository
import com.xxlionxx.prometey.data.repository.UserGoalRepositoryImpl
import com.xxlionxx.prometey.domain.repository.UserGoalRepository
import com.xxlionxx.prometey.data.repository.UserPreferenceRepositoryImpl
import com.xxlionxx.prometey.domain.repository.UserPreferenceRepository
import com.xxlionxx.prometey.data.repository.UserProfileRepositoryImpl
import com.xxlionxx.prometey.domain.repository.UserProfileRepository
import com.xxlionxx.prometey.data.repository.UserRepositoryImpl
import com.xxlionxx.prometey.domain.repository.UserRepository
import com.xxlionxx.prometey.data.repository.AIActionRepositoryImpl
import com.xxlionxx.prometey.domain.repository.AIActionRepository
import com.xxlionxx.prometey.data.repository.AIModelRepositoryImpl
import com.xxlionxx.prometey.domain.repository.AIModelRepository

val repositoryModule = module {

    single<AIRepository> {
        AIRepositoryImpl(
            aiSettingsRepository = get(),
            openAIDataSource = get(),
            geminiDataSource = get()
        )
    }


    single<AIImageRepository> {
        AIImageRepositoryImpl(
            openAIDataSource = get(),
            localImageDataUrlProvider = get()
        )
    }

    single<AIActionPolicyRepository> {
        AIActionPolicyRepositoryImpl(
            policyDao = get(),
            permissionDao = get()
        )
    }

    single<AIBehaviorRepository> {
        AIBehaviorRepositoryImpl(
            dao = get()
        )
    }

    single<AIInstructionRepository> {
        AIInstructionRepositoryImpl(
            dao = get()
        )
    }

    single<AIKnowledgeRepository> {
        AIKnowledgeRepositoryImpl(
            dao = get()
        )
    }

    single<AISettingsRepository> {
        AISettingsRepositoryImpl(
            settingsDao = get(),
            modelDao = get()
        )
    }

    single<AppSettingsRepository> {
        AppSettingsRepositoryImpl(
            context = get()
        )
    }

    single<AttachmentRepository> {
        AttachmentRepositoryImpl(
            dao = get()
        )
    }

    single<ConversationRepository> {
        ConversationRepositoryImpl(
            dao = get()
        )
    }

    single<ForecastDataRepository> {
        ForecastDataRepositoryImpl(
            dataSource = get()
        )
    }

    single<ForecastFactorRepository> {
        ForecastFactorRepositoryImpl(
            dao = get()
        )
    }

    single<ForecastFactorSourceRepository> {
        ForecastFactorSourceRepositoryImpl(
            dao = get()
        )
    }

    single<ForecastRecommendationRepository> {
        ForecastRecommendationRepositoryImpl(
            dao = get()
        )
    }

    single<ForecastRepository> {
        ForecastRepositoryImpl(
            dao = get()
        )
    }

    single<ForecastScenarioRepository> {
        ForecastScenarioRepositoryImpl(
            dao = get()
        )
    }

    single<ForecastSourceRepository> {
        ForecastSourceRepositoryImpl(
            dao = get()
        )
    }

    single<MemoryRepository> {
        MemoryRepositoryImpl(
            dao = get()
        )
    }

    single<MessageRepository> {
        MessageRepositoryImpl(
            dao = get(),
            attachmentRepository = get()
        )
    }

    single<SecureStorageRepository> {
        SecureStorageRepositoryImpl()
    }

    single<UserGoalRepository> {
        UserGoalRepositoryImpl(
            dao = get()
        )
    }

    single<UserPreferenceRepository> {
        UserPreferenceRepositoryImpl(
            dao = get()
        )
    }

    single<UserProfileRepository> {
        UserProfileRepositoryImpl(
            dao = get()
        )
    }

    single<UserRepository> {
        UserRepositoryImpl(
            dao = get()
        )
    }

    single<AIActionRepository> {
        AIActionRepositoryImpl(
            permissionDao = get()
        )
    }

    single<AIModelRepository> {
        AIModelRepositoryImpl(
            dao = get()
        )
    }
}