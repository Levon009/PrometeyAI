package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.ForecastSource

interface ForecastSourceRepository {

    suspend fun getSourceById(id: String): ForecastSource?

    suspend fun saveSource(source: ForecastSource)

    suspend fun deleteSource(id: String)
}