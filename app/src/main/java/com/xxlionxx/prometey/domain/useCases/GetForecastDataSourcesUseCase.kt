package com.xxlionxx.prometey.domain.useCases

import com.xxlionxx.prometey.domain.model.ForecastSource
import com.xxlionxx.prometey.domain.repository.ForecastDataRepository

class GetForecastDataSourcesUseCase(
    private val forecastDataRepository: ForecastDataRepository
) {

    suspend operator fun invoke(topic: String, query: String): List<ForecastSource> {
        return forecastDataRepository.getSources(
            topic = topic,
            query = query
        )
    }
}