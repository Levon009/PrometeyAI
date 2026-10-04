package com.xxlionxx.prometey.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xxlionxx.prometey.data.local.entity.AIActionPermissionEntity

@Dao
interface AIActionPermissionDao {

    @Query("SELECT * FROM ai_action_permissions")
    suspend fun getPermissions(): List<AIActionPermissionEntity>

    @Query("SELECT * FROM ai_action_permissions WHERE action_name = :action")
    suspend fun getPermission(action: String): AIActionPermissionEntity?

    @Insert
    suspend fun insertPermission(permission: AIActionPermissionEntity)

    @Update
    suspend fun updatePermission(permission: AIActionPermissionEntity)
}