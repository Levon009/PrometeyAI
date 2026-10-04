package com.xxlionxx.prometey.presentation.events

import com.xxlionxx.prometey.domain.model.Forecast
import com.xxlionxx.prometey.domain.model.ForecastFactor
import com.xxlionxx.prometey.domain.model.ForecastFactorSource
import com.xxlionxx.prometey.domain.model.ForecastRecommendation
import com.xxlionxx.prometey.domain.model.ForecastScenario
import com.xxlionxx.prometey.domain.model.ForecastSource

sealed interface ForecastEvent : MviEvent {

    data class LoadForecasts(
        val userId: String
    ) : ForecastEvent

    data class LoadForecast(
        val forecastId: String
    ) : ForecastEvent

    data class SaveForecast(
        val forecast: Forecast
    ) : ForecastEvent

    data class UpdateForecast(
        val forecast: Forecast
    ) : ForecastEvent

    data class DeleteForecast(
        val forecastId: String
    ) : ForecastEvent

    data class LoadFactors(
        val forecastId: String
    ) : ForecastEvent

    data class SaveFactor(
        val factor: ForecastFactor
    ) : ForecastEvent

    data class UpdateFactor(
        val factor: ForecastFactor
    ) : ForecastEvent

    data class DeleteFactor(
        val factorId: String
    ) : ForecastEvent

    data class LoadFactorSources(
        val factorId: String
    ) : ForecastEvent

    data class SaveFactorSource(
        val factorSource: ForecastFactorSource
    ) : ForecastEvent

    data class DeleteFactorSource(
        val factorId: String,
        val sourceId: String
    ) : ForecastEvent

    data class LoadRecommendations(
        val forecastId: String
    ) : ForecastEvent

    data class SaveRecommendation(
        val recommendation: ForecastRecommendation
    ) : ForecastEvent

    data class UpdateRecommendation(
        val recommendation: ForecastRecommendation
    ) : ForecastEvent

    data class LoadScenarios(
        val forecastId: String
    ) : ForecastEvent

    data class SaveScenario(
        val scenario: ForecastScenario
    ) : ForecastEvent

    data class UpdateScenario(
        val scenario: ForecastScenario
    ) : ForecastEvent

    data class DeleteScenario(
        val scenarioId: String
    ) : ForecastEvent

    data class LoadSource(
        val sourceId: String
    ) : ForecastEvent

    data class SaveSource(
        val source: ForecastSource
    ) : ForecastEvent

    data class DeleteSource(
        val sourceId: String
    ) : ForecastEvent

    data class LoadDataSources(
        val topic: String,
        val query: String
    ) : ForecastEvent

    data object ClearForecastState : ForecastEvent
}