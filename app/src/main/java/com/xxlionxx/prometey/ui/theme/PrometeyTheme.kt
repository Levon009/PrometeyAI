package com.xxlionxx.prometey.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf

val LocalAppColors = compositionLocalOf {
    MatrixColors
}

private fun matrixColorScheme(): ColorScheme {
    return darkColorScheme(
        primary = MatrixColors.primary,
        onPrimary = MatrixColors.background,
        secondary = MatrixColors.secondary,
        onSecondary = MatrixColors.background,
        background = MatrixColors.background,
        onBackground = MatrixColors.textPrimary,
        surface = MatrixColors.surface,
        onSurface = MatrixColors.textPrimary,
        surfaceVariant = MatrixColors.surfaceVariant,
        onSurfaceVariant = MatrixColors.textSecondary,
        error = MatrixColors.error,
        onError = MatrixColors.textPrimary
    )
}

private fun lightColorScheme(): ColorScheme {
    return lightColorScheme(
        primary = LightColors.primary,
        onPrimary = LightColors.surface,
        secondary = LightColors.secondary,
        onSecondary = LightColors.surface,
        background = LightColors.background,
        onBackground = LightColors.textPrimary,
        surface = LightColors.surface,
        onSurface = LightColors.textPrimary,
        surfaceVariant = LightColors.surfaceVariant,
        onSurfaceVariant = LightColors.textSecondary,
        error = LightColors.error,
        onError = LightColors.surface
    )
}

private fun parchmentColorScheme(): ColorScheme {
    return lightColorScheme(
        primary = ParchmentColors.primary,
        onPrimary = ParchmentColors.surface,
        secondary = ParchmentColors.secondary,
        onSecondary = ParchmentColors.surface,
        background = ParchmentColors.background,
        onBackground = ParchmentColors.textPrimary,
        surface = ParchmentColors.surface,
        onSurface = ParchmentColors.textPrimary,
        surfaceVariant = ParchmentColors.surfaceVariant,
        onSurfaceVariant = ParchmentColors.textSecondary,
        error = ParchmentColors.error,
        onError = ParchmentColors.surface
    )
}

@Composable
fun PrometeyTheme(
    theme: AppTheme = AppTheme.MATRIX,
    content: @Composable () -> Unit
) {
    val appColors = when (theme) {
        AppTheme.MATRIX -> MatrixColors
        AppTheme.LIGHT -> LightColors
        AppTheme.PARCHMENT -> ParchmentColors
    }

    val colorScheme = when (theme) {
        AppTheme.MATRIX -> matrixColorScheme()
        AppTheme.LIGHT -> lightColorScheme()
        AppTheme.PARCHMENT -> parchmentColorScheme()
    }

    CompositionLocalProvider(
        LocalAppColors provides appColors
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography(),
            content = content
        )
    }
}