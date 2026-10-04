package com.xxlionxx.prometey.ui.theme

import androidx.compose.ui.graphics.Color

data class AppColors(
    val background: Color,
    val surface: Color,
    val surfaceVariant: Color,
    val primary: Color,
    val secondary: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textMuted: Color,
    val error: Color,
    val success: Color,
    val divider: Color
)

val MatrixColors = AppColors(
    background = Color(0xFF0A0A0A),
    surface = Color(0xFF111111),
    surfaceVariant = Color(0xFF1A1A1A),
    primary = Color(0xFF66FF66),
    secondary = Color(0xFF33CC66),
    textPrimary = Color(0xFFE8E8E8),
    textSecondary = Color(0xFFB8B8B8),
    textMuted = Color(0xFF777777),
    error = Color(0xFFFF5555),
    success = Color(0xFF66FF66),
    divider = Color(0xFF2A2A2A)
)

val LightColors = AppColors(
    background = Color(0xFFF8F8F8),
    surface = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFFEDEDED),
    primary = Color(0xFF1B5E20),
    secondary = Color(0xFF388E3C),
    textPrimary = Color(0xFF171717),
    textSecondary = Color(0xFF4A4A4A),
    textMuted = Color(0xFF777777),
    error = Color(0xFFB3261E),
    success = Color(0xFF2E7D32),
    divider = Color(0xFFD6D6D6)
)

val ParchmentColors = AppColors(
    background = Color(0xFFE6D29A),
    surface = Color(0xFFF0DFB3),
    surfaceVariant = Color(0xFFD6BC78),
    primary = Color(0xFF5C4326),
    secondary = Color(0xFF8A642F),
    textPrimary = Color(0xFF2E2418),
    textSecondary = Color(0xFF554632),
    textMuted = Color(0xFF78664B),
    error = Color(0xFF8B2E24),
    success = Color(0xFF4F6634),
    divider = Color(0xFFB79A61)
)
