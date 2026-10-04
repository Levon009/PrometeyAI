package com.xxlionxx.prometey.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xxlionxx.prometey.data.local.dao.AIActionPermissionDao
import com.xxlionxx.prometey.data.local.dao.AIActionPolicyDao
import com.xxlionxx.prometey.data.local.dao.AIBehaviorDao
import com.xxlionxx.prometey.data.local.dao.AIInstructionDao
import com.xxlionxx.prometey.data.local.dao.AIKnowledgeDao
import com.xxlionxx.prometey.data.local.dao.AIModelDao
import com.xxlionxx.prometey.data.local.dao.AISettingsDao
import com.xxlionxx.prometey.data.local.dao.AttachmentDao
import com.xxlionxx.prometey.data.local.dao.ConversationDao
import com.xxlionxx.prometey.data.local.dao.ForecastDao
import com.xxlionxx.prometey.data.local.dao.ForecastFactorDao
import com.xxlionxx.prometey.data.local.dao.ForecastFactorSourceDao
import com.xxlionxx.prometey.data.local.dao.ForecastRecommendationDao
import com.xxlionxx.prometey.data.local.dao.ForecastScenarioDao
import com.xxlionxx.prometey.data.local.dao.ForecastSourceDao
import com.xxlionxx.prometey.data.local.dao.MemoryDao
import com.xxlionxx.prometey.data.local.dao.MessageDao
import com.xxlionxx.prometey.data.local.dao.UserDao
import com.xxlionxx.prometey.data.local.dao.UserGoalDao
import com.xxlionxx.prometey.data.local.dao.UserPreferenceDao
import com.xxlionxx.prometey.data.local.dao.UserProfileDao
import com.xxlionxx.prometey.data.local.entity.AIActionPermissionEntity
import com.xxlionxx.prometey.data.local.entity.AIActionPolicyEntity
import com.xxlionxx.prometey.data.local.entity.AIBehaviorEntity
import com.xxlionxx.prometey.data.local.entity.AIInstructionEntity
import com.xxlionxx.prometey.data.local.entity.AIKnowledgeEntity
import com.xxlionxx.prometey.data.local.entity.AIModelEntity
import com.xxlionxx.prometey.data.local.entity.AISettingsEntity
import com.xxlionxx.prometey.data.local.entity.AttachmentEntity
import com.xxlionxx.prometey.data.local.entity.ConversationEntity
import com.xxlionxx.prometey.data.local.entity.ForecastEntity
import com.xxlionxx.prometey.data.local.entity.ForecastFactorEntity
import com.xxlionxx.prometey.data.local.entity.ForecastFactorSourceEntity
import com.xxlionxx.prometey.data.local.entity.ForecastRecommendationEntity
import com.xxlionxx.prometey.data.local.entity.ForecastScenarioEntity
import com.xxlionxx.prometey.data.local.entity.ForecastSourceEntity
import com.xxlionxx.prometey.data.local.entity.MemoryEntity
import com.xxlionxx.prometey.data.local.entity.MessageEntity
import com.xxlionxx.prometey.data.local.entity.UserEntity
import com.xxlionxx.prometey.data.local.entity.UserGoalEntity
import com.xxlionxx.prometey.data.local.entity.UserPreferenceEntity
import com.xxlionxx.prometey.data.local.entity.UserProfileEntity

@Database(
    entities = [
        UserEntity::class,
        UserProfileEntity::class,
        UserPreferenceEntity::class,
        UserGoalEntity::class,
        MemoryEntity::class,
        ConversationEntity::class,
        MessageEntity::class,
        AttachmentEntity::class,
        AISettingsEntity::class,
        AIBehaviorEntity::class,
        AIActionPolicyEntity::class,
        AIActionPermissionEntity::class,
        AIInstructionEntity::class,
        AIKnowledgeEntity::class,
        AIModelEntity::class,
        ForecastEntity::class,
        ForecastScenarioEntity::class,
        ForecastFactorEntity::class,
        ForecastFactorSourceEntity::class,
        ForecastSourceEntity::class,
        ForecastRecommendationEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class PrometeyDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun userProfileDao(): UserProfileDao
    abstract fun userPreferenceDao(): UserPreferenceDao
    abstract fun userGoalDao(): UserGoalDao

    abstract fun memoryDao(): MemoryDao
    abstract fun conversationDao(): ConversationDao
    abstract fun messageDao(): MessageDao
    abstract fun attachmentDao(): AttachmentDao

    abstract fun aiSettingsDao(): AISettingsDao
    abstract fun aiBehaviorDao(): AIBehaviorDao
    abstract fun aiActionPolicyDao(): AIActionPolicyDao
    abstract fun aiActionPermissionDao(): AIActionPermissionDao
    abstract fun aiInstructionDao(): AIInstructionDao
    abstract fun aiKnowledgeDao(): AIKnowledgeDao
    abstract fun aiModelDao(): AIModelDao

    abstract fun forecastDao(): ForecastDao
    abstract fun forecastScenarioDao(): ForecastScenarioDao
    abstract fun forecastFactorDao(): ForecastFactorDao
    abstract fun forecastFactorSourceDao(): ForecastFactorSourceDao
    abstract fun forecastSourceDao(): ForecastSourceDao
    abstract fun forecastRecommendationDao(): ForecastRecommendationDao
}