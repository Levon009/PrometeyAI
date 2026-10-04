package com.xxlionxx.prometey.data.local

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

private const val APP_SETTINGS_FILE = "app_settings"

val Context.appSettingsDataStore by preferencesDataStore(
    name = APP_SETTINGS_FILE
)