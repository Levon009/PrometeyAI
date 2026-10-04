package com.xxlionxx.prometey.presentation.states

import com.xxlionxx.prometey.domain.model.Forecast
import com.xxlionxx.prometey.domain.model.ForecastFactor
import com.xxlionxx.prometey.domain.model.ForecastFactorSource
import com.xxlionxx.prometey.domain.model.ForecastRecommendation
import com.xxlionxx.prometey.domain.model.ForecastScenario
import com.xxlionxx.prometey.domain.model.ForecastSource

data class ForecastState(
    val forecasts: List<Forecast> = emptyList(),
    val selectedForecast: Forecast? = null,

    val factors: List<ForecastFactor> = emptyList(),
    val factorSources: List<ForecastFactorSource> = emptyList(),

    val recommendations: List<ForecastRecommendation> = emptyList(),

    val scenarios: List<ForecastScenario> = emptyList(),

    val selectedSource: ForecastSource? = null,
    val dataSources: List<ForecastSource> = emptyList(),

    val isLoading: Boolean = false,
    val isSaving: Boolean = false,
    val isDeleting: Boolean = false,

    val error: String? = null
) : MviState