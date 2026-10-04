package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.UserPreferenceDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.UserPreference
import com.xxlionxx.prometey.domain.repository.UserPreferenceRepository

class UserPreferenceRepositoryImpl(
    private val dao: UserPreferenceDao
) : UserPreferenceRepository {

    override suspend fun getPreferences(
        userId: String
    ): List<UserPreference> {
        return dao.getPreferences(userId)
            .map { it.toDomain() }
    }

    override suspend fun savePreference(
        preference: UserPreference
    ) {
        dao.insertPreference(
            preference.toEntity()
        )
    }

    override suspend fun updatePreference(
        preference: UserPreference
    ) {
        dao.updatePreference(
            preference.toEntity()
        )
    }

    override suspend fun deletePreference(
        id: String
    ) {
        val preference = dao.getPreferenceById(id)
            ?: return

        dao.deletePreference(preference)
    }
}