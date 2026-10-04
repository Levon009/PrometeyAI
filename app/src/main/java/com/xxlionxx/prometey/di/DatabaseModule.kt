package com.xxlionxx.prometey.di

import androidx.room.Room
import com.xxlionxx.prometey.data.local.PrometeyDatabase
import com.xxlionxx.prometey.data.local.MIGRATION_1_2
import com.xxlionxx.prometey.data.local.AIModelInitializer
import org.koin.dsl.module

val databaseModule = module {

    single<PrometeyDatabase> {
        Room.databaseBuilder(
            get(),
            PrometeyDatabase::class.java,
            "prometey_database"
        )
            .addMigrations(MIGRATION_1_2)
            .build()
    }

    single { get<PrometeyDatabase>().userDao() }
    single { get<PrometeyDatabase>().userProfileDao() }
    single { get<PrometeyDatabase>().userPreferenceDao() }
    single { get<PrometeyDatabase>().userGoalDao() }

    single { get<PrometeyDatabase>().memoryDao() }
    single { get<PrometeyDatabase>().conversationDao() }
    single { get<PrometeyDatabase>().messageDao() }
    single { get<PrometeyDatabase>().attachmentDao() }

    single { get<PrometeyDatabase>().aiSettingsDao() }
    single { get<PrometeyDatabase>().aiBehaviorDao() }
    single { get<PrometeyDatabase>().aiActionPolicyDao() }
    single { get<PrometeyDatabase>().aiActionPermissionDao() }
    single { get<PrometeyDatabase>().aiInstructionDao() }
    single { get<PrometeyDatabase>().aiKnowledgeDao() }
    single { get<PrometeyDatabase>().aiModelDao() }
    single {
        AIModelInitializer(
            dao = get()
        )
    }

    single { get<PrometeyDatabase>().forecastDao() }
    single { get<PrometeyDatabase>().forecastScenarioDao() }
    single { get<PrometeyDatabase>().forecastFactorDao() }
    single { get<PrometeyDatabase>().forecastFactorSourceDao() }
    single { get<PrometeyDatabase>().forecastSourceDao() }
    single { get<PrometeyDatabase>().forecastRecommendationDao() }
}