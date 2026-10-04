package com.xxlionxx.prometey.presentation

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

data class ForecastViewModelDependencies(
    val getForecasts: GetForecastsUseCase,
    val getForecastById: GetForecastByIdUseCase,
    val saveForecast: SaveForecastUseCase,
    val updateForecast: UpdateForecastUseCase,
    val deleteForecast: DeleteForecastUseCase,

    val getForecastFactors: GetForecastFactorsUseCase,
    val saveForecastFactor: SaveForecastFactorUseCase,
    val updateForecastFactor: UpdateForecastFactorUseCase,
    val deleteForecastFactor: DeleteForecastFactorUseCase,

    val getForecastFactorSources: GetForecastFactorSourcesUseCase,
    val saveForecastFactorSource: SaveForecastFactorSourceUseCase,
    val deleteForecastFactorSource: DeleteForecastFactorSourceUseCase,

    val getForecastRecommendations: GetForecastRecommendationsUseCase,
    val saveForecastRecommendation: SaveForecastRecommendationUseCase,
    val updateForecastRecommendation: UpdateForecastRecommendationUseCase,

    val getForecastScenarios: GetForecastScenariosUseCase,
    val saveForecastScenario: SaveForecastScenarioUseCase,
    val updateForecastScenario: UpdateForecastScenarioUseCase,
    val deleteForecastScenario: DeleteForecastScenarioUseCase,

    val getForecastSourceById: GetForecastSourceByIdUseCase,
    val saveForecastSource: SaveForecastSourceUseCase,
    val deleteForecastSource: DeleteForecastSourceUseCase,

    val getForecastDataSources: GetForecastDataSourcesUseCase
)