package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.ForecastSourceDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.ForecastSource
import com.xxlionxx.prometey.domain.repository.ForecastSourceRepository

class ForecastSourceRepositoryImpl(
    private val dao: ForecastSourceDao
) : ForecastSourceRepository {

    override suspend fun getSourceById(
        id: String
    ): ForecastSource? {
        return dao.getSourceById(id)
            ?.toDomain()
    }

    override suspend fun saveSource(
        source: ForecastSource
    ) {
        dao.insertSource(
            source.toEntity()
        )
    }

    override suspend fun deleteSource(
        id: String
    ) {
        val source = dao.getSourceById(id)
            ?: return

        dao.deleteSource(source)
    }
}