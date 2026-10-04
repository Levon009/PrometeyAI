package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.UserProfile

interface UserProfileRepository {

    suspend fun getProfile(userId: String): UserProfile?

    suspend fun saveProfile(profile: UserProfile)

    suspend fun updateProfile(profile: UserProfile)
}