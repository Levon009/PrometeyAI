package com.xxlionxx.prometey.data.remote

import android.content.Context
import android.util.Base64
import java.io.IOException
import androidx.core.net.toUri

class LocalImageDataUrlProvider(
    private val context: Context
) {

    fun provide(imageUri: String): String {
        val uri = imageUri.toUri()

        val mimeType = context.contentResolver.getType(uri)
            ?: throw IOException("Unable to determine image MIME type: $imageUri")

        val bytes = context.contentResolver.openInputStream(uri)?.use { inputStream ->
            inputStream.readBytes()
        } ?: throw IOException("Unable to read image: $imageUri")

        val base64 = Base64.encodeToString(bytes, Base64.NO_WRAP)

        return "data:$mimeType;base64,$base64"
    }
}