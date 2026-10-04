package com.xxlionxx.prometey.data.local

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {

    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            """
            ALTER TABLE user_profiles
            ADD COLUMN avatarUri TEXT
            """.trimIndent()
        )
    }
}