package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.UserProfileDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.UserProfile
import com.xxlionxx.prometey.domain.repository.UserProfileRepository

class UserProfileRepositoryImpl(
    private val dao: UserProfileDao
) : UserProfileRepository {

    override suspend fun getProfile(
        userId: String
    ): UserProfile? {
        return dao.getProfile(userId)
            ?.toDomain()
    }

    override suspend fun saveProfile(
        profile: UserProfile
    ) {
        dao.insertProfile(
            profile.toEntity()
        )
    }

    override suspend fun updateProfile(
        profile: UserProfile
    ) {
        dao.updateProfile(
            profile.toEntity()
        )
    }
}