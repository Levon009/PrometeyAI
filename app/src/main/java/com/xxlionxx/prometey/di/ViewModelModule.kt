package com.xxlionxx.prometey.di

import com.xxlionxx.prometey.presentation.AIViewModel
import com.xxlionxx.prometey.presentation.ChatViewModel
import com.xxlionxx.prometey.presentation.ChatViewModelDependencies
import com.xxlionxx.prometey.presentation.MemoryViewModel
import com.xxlionxx.prometey.presentation.ProfileViewModel
import com.xxlionxx.prometey.presentation.GoalViewModel
import com.xxlionxx.prometey.presentation.PreferenceViewModel
import com.xxlionxx.prometey.presentation.SettingsViewModel
import com.xxlionxx.prometey.presentation.ForecastViewModel
import com.xxlionxx.prometey.presentation.ForecastViewModelDependencies
import com.xxlionxx.prometey.presentation.ThemeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    single {
        ForecastViewModelDependencies(
            getForecasts = get(),
            getForecastById = get(),
            saveForecast = get(),
            updateForecast = get(),
            deleteForecast = get(),

            getForecastFactors = get(),
            saveForecastFactor = get(),
            updateForecastFactor = get(),
            deleteForecastFactor = get(),

            getForecastFactorSources = get(),
            saveForecastFactorSource = get(),
            deleteForecastFactorSource = get(),

            getForecastRecommendations = get(),
            saveForecastRecommendation = get(),
            updateForecastRecommendation = get(),

            getForecastScenarios = get(),
            saveForecastScenario = get(),
            updateForecastScenario = get(),
            deleteForecastScenario = get(),

            getForecastSourceById = get(),
            saveForecastSource = get(),
            deleteForecastSource = get(),

            getForecastDataSources = get()
        )
    }

    single {
        ChatViewModelDependencies(
            getConversations = get(),
            getConversationById = get(),
            saveConversation = get(),
            updateConversation = get(),
            deleteConversation = get(),

            getMessages = get(),
            getMessageById = get(),
            saveMessage = get(),
            updateMessage = get(),
            deleteMessage = get(),

            getAttachments = get(),
            saveAttachment = get(),
            deleteAttachment = get(),

            generateAIResponse = get(),
            analyzeImages = get(),

            getMemories = get(),
            getUserProfile = get(),
            getUserGoals = get(),
            getUserPreferences = get()
        )
    }

    viewModelOf(::ChatViewModel)
    viewModelOf(::MemoryViewModel)
    viewModelOf(::ProfileViewModel)
    viewModelOf(::GoalViewModel)
    viewModelOf(::PreferenceViewModel)
    viewModelOf(::SettingsViewModel)
    viewModelOf(::AIViewModel)
    viewModelOf(::ForecastViewModel)
    viewModelOf(::ThemeViewModel)
}