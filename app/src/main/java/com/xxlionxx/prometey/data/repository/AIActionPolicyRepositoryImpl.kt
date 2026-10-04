package com.xxlionxx.prometey.data.repository

import com.xxlionxx.prometey.data.local.dao.AIActionPermissionDao
import com.xxlionxx.prometey.data.local.dao.AIActionPolicyDao
import com.xxlionxx.prometey.data.local.mapper.toDomain
import com.xxlionxx.prometey.data.local.mapper.toEntity
import com.xxlionxx.prometey.domain.model.AIActionPolicy
import com.xxlionxx.prometey.domain.repository.AIActionPolicyRepository

class AIActionPolicyRepositoryImpl(
    private val policyDao: AIActionPolicyDao,
    private val permissionDao: AIActionPermissionDao
) : AIActionPolicyRepository {

    override suspend fun getPolicy(): AIActionPolicy {
        val policy = policyDao.getPolicy(1)
        val permissions = permissionDao.getPermissions()
            .map { it.toDomain() }

        return policy?.toDomain(permissions)
            ?: AIActionPolicy(
                permissions = permissions,
                allowAutomaticActions = false
            )
    }

    override suspend fun savePolicy(
        policy: AIActionPolicy
    ) {
        policyDao.insertPolicy(
            policy.toEntity()
        )

        policy.permissions.forEach { permission ->
            permissionDao.insertPermission(
                permission.toEntity()
            )
        }
    }

    override suspend fun updatePolicy(
        policy: AIActionPolicy
    ) {
        policyDao.updatePolicy(
            policy.toEntity()
        )

        policy.permissions.forEach { permission ->
            permissionDao.updatePermission(
                permission.toEntity()
            )
        }
    }
}