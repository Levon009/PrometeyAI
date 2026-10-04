package com.xxlionxx.prometey.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.xxlionxx.prometey.presentation.ThemeViewModel
import com.xxlionxx.prometey.ui.theme.AppColors
import com.xxlionxx.prometey.ui.theme.AppTheme
import com.xxlionxx.prometey.ui.theme.LightColors
import com.xxlionxx.prometey.ui.theme.LocalAppColors
import com.xxlionxx.prometey.ui.theme.MatrixColors
import com.xxlionxx.prometey.ui.theme.ParchmentColors

@Composable
fun ThemeScreen(
    modifier: Modifier = Modifier,
    viewModel: ThemeViewModel
) {
    val currentTheme by viewModel.theme.collectAsStateWithLifecycle()
    val colors = LocalAppColors.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colors.background)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Theme",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = colors.textPrimary
        )

        Text(
            text = "Choose how Prometey looks across the entire app.",
            style = MaterialTheme.typography.bodyLarge,
            color = colors.textSecondary
        )

        Spacer(modifier = Modifier.height(8.dp))

        ThemeOption(
            title = "Matrix",
            description = "Dark interface with green accents",
            previewColor = MatrixColors.background,
            selected = currentTheme == AppTheme.MATRIX,
            colors = colors,
            onClick = {
                viewModel.setTheme(AppTheme.MATRIX)
            }
        )

        ThemeOption(
            title = "Light",
            description = "Clean light interface",
            previewColor = LightColors.background,
            selected = currentTheme == AppTheme.LIGHT,
            colors = colors,
            onClick = {
                viewModel.setTheme(AppTheme.LIGHT)
            }
        )

        ThemeOption(
            title = "Parchment",
            description = "Warm aged-paper interface",
            previewColor = ParchmentColors.background,
            selected = currentTheme == AppTheme.PARCHMENT,
            colors = colors,
            onClick = {
                viewModel.setTheme(AppTheme.PARCHMENT)
            }
        )
    }
}

@Composable
private fun ThemeOption(
    title: String,
    description: String,
    previewColor: Color,
    selected: Boolean,
    colors: AppColors,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(colors.surface)
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(previewColor)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = colors.textPrimary
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = colors.textSecondary
            )
        }

        RadioButton(
            selected = selected,
            onClick = onClick
        )
    }
}