package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.ForecastFactorSourceDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.ForecastFactorSource
import com.xxlionxx.prometey.domain.repository.ForecastFactorSourceRepository

class ForecastFactorSourceRepositoryImpl(
    private val dao: ForecastFactorSourceDao
) : ForecastFactorSourceRepository {

    override suspend fun getSourcesForFactor(
        factorId: String
    ): List<ForecastFactorSource> {
        return dao.getSourcesForFactor(factorId)
            .map { it.toDomain() }
    }

    override suspend fun saveRelation(
        relation: ForecastFactorSource
    ) {
        dao.insertRelation(
            relation.toEntity()
        )
    }

    override suspend fun deleteRelation(
        factorId: String,
        sourceId: String
    ) {
        val relation = dao.getRelation(
            factorId = factorId,
            sourceId = sourceId
        ) ?: return

        dao.deleteRelation(relation)
    }
}