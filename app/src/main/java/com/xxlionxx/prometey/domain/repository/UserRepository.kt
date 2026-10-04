package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.User

interface UserRepository {

    suspend fun getUserById(id: String): User?

    suspend fun saveUser(user: User)

    suspend fun updateUser(user: User)
}