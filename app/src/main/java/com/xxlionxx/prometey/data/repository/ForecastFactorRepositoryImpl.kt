package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.ForecastFactorDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.ForecastFactor
import com.xxlionxx.prometey.domain.repository.ForecastFactorRepository

class ForecastFactorRepositoryImpl(
    private val dao: ForecastFactorDao
) : ForecastFactorRepository {

    override suspend fun getFactors(
        forecastId: String
    ): List<ForecastFactor> {
        return dao.getFactors(forecastId)
            .map { it.toDomain() }
    }

    override suspend fun saveFactor(
        factor: ForecastFactor
    ) {
        dao.insertFactor(
            factor.toEntity()
        )
    }

    override suspend fun updateFactor(
        factor: ForecastFactor
    ) {
        dao.updateFactor(
            factor.toEntity()
        )
    }

    override suspend fun deleteFactor(
        id: String
    ) {
        val factor = dao.getFactorById(id)
            ?: return

        dao.deleteFactor(factor)
    }
}