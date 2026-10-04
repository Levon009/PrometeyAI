package com.xxlionxx.prometey.domain.repository

import com.xxlionxx.prometey.domain.model.AIActionPolicy

interface AIActionPolicyRepository {

    suspend fun getPolicy(): AIActionPolicy

    suspend fun savePolicy(policy: AIActionPolicy)

    suspend fun updatePolicy(policy: AIActionPolicy)
}