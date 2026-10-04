package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.UserDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.User
import com.xxlionxx.prometey.domain.repository.UserRepository

class UserRepositoryImpl(
    private val dao: UserDao
) : UserRepository {

    override suspend fun getUserById(
        id: String
    ): User? {
        return dao.getUserById(id)
            ?.toDomain()
    }

    override suspend fun saveUser(
        user: User
    ) {
        dao.insertUser(
            user.toEntity()
        )
    }

    override suspend fun updateUser(
        user: User
    ) {
        dao.updateUser(
            user.toEntity()
        )
    }
}