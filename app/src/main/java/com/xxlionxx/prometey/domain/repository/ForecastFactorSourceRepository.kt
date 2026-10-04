package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.ForecastFactorSource

interface ForecastFactorSourceRepository {

    suspend fun getSourcesForFactor(factorId: String): List<ForecastFactorSource>

    suspend fun saveRelation(relation: ForecastFactorSource)

    suspend fun deleteRelation(factorId: String, sourceId: String)
}