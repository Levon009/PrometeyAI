package com.xxlionxx.prometey.ui.theme

import com.xxlionxx.prometey.domain.useCases.GetAppSettingStringUseCase
import com.xxlionxx.prometey.domain.useCases.SetAppSettingStringUseCase

class ThemeManager(
    private val getAppSettingStringUseCase: GetAppSettingStringUseCase,
    private val setAppSettingStringUseCase: SetAppSettingStringUseCase
) {

    suspend fun getTheme(): AppTheme {
        val savedTheme = getAppSettingStringUseCase(THEME_KEY)

        return savedTheme
            ?.let { value ->
                runCatching {
                    AppTheme.valueOf(value)
                }.getOrNull()
            }
            ?: AppTheme.MATRIX
    }

    suspend fun setTheme(theme: AppTheme) {
        setAppSettingStringUseCase(
            key = THEME_KEY,
            value = theme.name
        )
    }

    companion object {
        const val THEME_KEY = "prometey_theme"
    }
}