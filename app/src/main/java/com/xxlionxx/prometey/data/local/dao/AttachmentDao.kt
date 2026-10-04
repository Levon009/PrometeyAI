package com.xxlionxx.prometey.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.xxlionxx.prometey.data.local.entity.AttachmentEntity

@Dao
interface AttachmentDao {

    @Query("SELECT * FROM attachments WHERE messageId = :messageId")
    suspend fun getAttachments(messageId: String): List<AttachmentEntity>

    @Query("SELECT * FROM attachments WHERE id = :id")
    suspend fun getAttachmentById(id: String): AttachmentEntity?

    @Insert
    suspend fun insertAttachment(attachment: AttachmentEntity)

    @Delete
    suspend fun deleteAttachment(attachment: AttachmentEntity)
}