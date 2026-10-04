package com.xxlionxx.prometey.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xxlionxx.prometey.ui.theme.AppTheme
import com.xxlionxx.prometey.ui.theme.ThemeManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ThemeViewModel(
    private val themeManager: ThemeManager
) : ViewModel() {

    private val _theme = MutableStateFlow(AppTheme.MATRIX)

    val theme: StateFlow<AppTheme> = _theme.asStateFlow()

    init {
        loadTheme()
    }

    private fun loadTheme() {
        viewModelScope.launch {
            _theme.value = themeManager.getTheme()
        }
    }

    fun setTheme(theme: AppTheme) {
        if (_theme.value == theme) {
            return
        }

        _theme.value = theme

        viewModelScope.launch {
            themeManager.setTheme(theme)
        }
    }
}