package com.xxlionxx.prometey.presentation

import androidx.lifecycle.viewModelScope
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
import com.xxlionxx.prometey.presentation.events.ForecastEvent
import com.xxlionxx.prometey.presentation.states.ForecastState
import kotlinx.coroutines.launch

class ForecastViewModel(
    private val dependencies: ForecastViewModelDependencies
) : MviViewModel<ForecastEvent, ForecastState>(ForecastState()) {

    override fun onEvent(event: ForecastEvent) {
        when (event) {
            is ForecastEvent.LoadForecasts -> loadForecasts(event.userId)
            is ForecastEvent.LoadForecast -> loadForecast(event.forecastId)
            is ForecastEvent.SaveForecast -> saveForecast(event)
            is ForecastEvent.UpdateForecast -> updateForecast(event)
            is ForecastEvent.DeleteForecast -> deleteForecast(event.forecastId)

            is ForecastEvent.LoadFactors -> loadFactors(event.forecastId)
            is ForecastEvent.SaveFactor -> saveFactor(event)
            is ForecastEvent.UpdateFactor -> updateFactor(event)
            is ForecastEvent.DeleteFactor -> deleteFactor(event.factorId)

            is ForecastEvent.LoadFactorSources -> loadFactorSources(event.factorId)
            is ForecastEvent.SaveFactorSource -> saveFactorSource(event)
            is ForecastEvent.DeleteFactorSource ->
                deleteFactorSource(event.factorId, event.sourceId)

            is ForecastEvent.LoadRecommendations -> loadRecommendations(event.forecastId)
            is ForecastEvent.SaveRecommendation -> saveRecommendation(event)
            is ForecastEvent.UpdateRecommendation -> updateRecommendation(event)

            is ForecastEvent.LoadScenarios -> loadScenarios(event.forecastId)
            is ForecastEvent.SaveScenario -> saveScenario(event)
            is ForecastEvent.UpdateScenario -> updateScenario(event)
            is ForecastEvent.DeleteScenario -> deleteScenario(event.scenarioId)

            is ForecastEvent.LoadSource -> loadSource(event.sourceId)
            is ForecastEvent.SaveSource -> saveSource(event)
            is ForecastEvent.DeleteSource -> deleteSource(event.sourceId)

            is ForecastEvent.LoadDataSources ->
                loadDataSources(event.topic, event.query)

            ForecastEvent.ClearForecastState ->
                updateState { ForecastState() }
        }
    }

    private fun loadForecasts(userId: String) {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val forecasts = dependencies.getForecasts(userId)

                updateState {
                    it.copy(
                        forecasts = forecasts,
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

    private fun loadForecast(forecastId: String) {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val forecast = dependencies.getForecastById(forecastId)

                updateState {
                    it.copy(
                        selectedForecast = forecast,
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

    private fun saveForecast(event: ForecastEvent.SaveForecast) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                dependencies.saveForecast(event.forecast)

                updateState {
                    it.copy(
                        forecasts = it.forecasts + event.forecast,
                        selectedForecast = event.forecast,
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

    private fun updateForecast(event: ForecastEvent.UpdateForecast) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                dependencies.updateForecast(event.forecast)

                updateState {
                    it.copy(
                        forecasts = it.forecasts.map {
                            if (it.id == event.forecast.id) {
                                event.forecast
                            } else {
                                it
                            }
                        },
                        selectedForecast = event.forecast,
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

    private fun deleteForecast(forecastId: String) {
        viewModelScope.launch {
            updateState { it.copy(isDeleting = true, error = null) }

            try {
                dependencies.deleteForecast(forecastId)

                updateState {
                    it.copy(
                        forecasts = it.forecasts.filterNot { it.id == forecastId },
                        selectedForecast =
                            if (it.selectedForecast?.id == forecastId) {
                                null
                            } else {
                                it.selectedForecast
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

    private fun loadFactors(forecastId: String) {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val factors = dependencies.getForecastFactors(forecastId)

                updateState {
                    it.copy(
                        factors = factors,
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

    private fun saveFactor(event: ForecastEvent.SaveFactor) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                dependencies.saveForecastFactor(event.factor)

                updateState {
                    it.copy(
                        factors = it.factors + event.factor,
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

    private fun updateFactor(event: ForecastEvent.UpdateFactor) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                dependencies.updateForecastFactor(event.factor)

                updateState {
                    it.copy(
                        factors = it.factors.map {
                            if (it.id == event.factor.id) {
                                event.factor
                            } else {
                                it
                            }
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

    private fun deleteFactor(factorId: String) {
        viewModelScope.launch {
            updateState { it.copy(isDeleting = true, error = null) }

            try {
                dependencies.deleteForecastFactor(factorId)

                updateState {
                    it.copy(
                        factors = it.factors.filterNot { it.id == factorId },
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

    private fun loadFactorSources(factorId: String) {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val sources = dependencies.getForecastFactorSources(factorId)

                updateState {
                    it.copy(
                        factorSources = sources,
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

    private fun saveFactorSource(event: ForecastEvent.SaveFactorSource) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                dependencies.saveForecastFactorSource(event.factorSource)

                updateState {
                    it.copy(
                        factorSources = it.factorSources + event.factorSource,
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

    private fun deleteFactorSource(
        factorId: String,
        sourceId: String
    ) {
        viewModelScope.launch {
            updateState { it.copy(isDeleting = true, error = null) }

            try {
                dependencies.deleteForecastFactorSource(
                    factorId = factorId,
                    sourceId = sourceId
                )

                updateState {
                    it.copy(
                        factorSources = it.factorSources.filterNot {
                            it.factorId == factorId && it.sourceId == sourceId
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

    private fun loadRecommendations(forecastId: String) {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val recommendations = dependencies.getForecastRecommendations(forecastId)

                updateState {
                    it.copy(
                        recommendations = recommendations,
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

    private fun saveRecommendation(event: ForecastEvent.SaveRecommendation) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                dependencies.saveForecastRecommendation(event.recommendation)

                updateState {
                    it.copy(
                        recommendations = it.recommendations + event.recommendation,
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

    private fun updateRecommendation(event: ForecastEvent.UpdateRecommendation) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                dependencies.updateForecastRecommendation(event.recommendation)

                updateState {
                    it.copy(
                        recommendations = it.recommendations.map {
                            if (it.id == event.recommendation.id) {
                                event.recommendation
                            } else {
                                it
                            }
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

    private fun loadScenarios(forecastId: String) {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val scenarios = dependencies.getForecastScenarios(forecastId)

                updateState {
                    it.copy(
                        scenarios = scenarios,
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

    private fun saveScenario(event: ForecastEvent.SaveScenario) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                dependencies.saveForecastScenario(event.scenario)

                updateState {
                    it.copy(
                        scenarios = it.scenarios + event.scenario,
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

    private fun updateScenario(event: ForecastEvent.UpdateScenario) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                dependencies.updateForecastScenario(event.scenario)

                updateState {
                    it.copy(
                        scenarios = it.scenarios.map {
                            if (it.id == event.scenario.id) {
                                event.scenario
                            } else {
                                it
                            }
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

    private fun deleteScenario(scenarioId: String) {
        viewModelScope.launch {
            updateState { it.copy(isDeleting = true, error = null) }

            try {
                dependencies.deleteForecastScenario(scenarioId)

                updateState {
                    it.copy(
                        scenarios = it.scenarios.filterNot { it.id == scenarioId },
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

    private fun loadSource(sourceId: String) {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val source = dependencies.getForecastSourceById(sourceId)

                updateState {
                    it.copy(
                        selectedSource = source,
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

    private fun saveSource(event: ForecastEvent.SaveSource) {
        viewModelScope.launch {
            updateState { it.copy(isSaving = true, error = null) }

            try {
                dependencies.saveForecastSource(event.source)

                updateState {
                    it.copy(
                        dataSources = it.dataSources + event.source,
                        selectedSource = event.source,
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

    private fun deleteSource(sourceId: String) {
        viewModelScope.launch {
            updateState { it.copy(isDeleting = true, error = null) }

            try {
                dependencies.deleteForecastSource(sourceId)

                updateState {
                    it.copy(
                        dataSources = it.dataSources.filterNot { it.id == sourceId },
                        selectedSource =
                            if (it.selectedSource?.id == sourceId) {
                                null
                            } else {
                                it.selectedSource
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

    private fun loadDataSources(topic: String, query: String) {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }

            try {
                val sources = dependencies.getForecastDataSources(topic, query)

                updateState {
                    it.copy(
                        dataSources = sources,
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
}