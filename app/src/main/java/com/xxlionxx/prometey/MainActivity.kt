package com.xxlionxx.prometey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.xxlionxx.prometey.navigation.NavGraph
import com.xxlionxx.prometey.presentation.ThemeViewModel
import com.xxlionxx.prometey.ui.theme.PrometeyTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            val themeViewModel: ThemeViewModel = koinViewModel()
            val currentTheme by themeViewModel.theme.collectAsStateWithLifecycle()

            PrometeyTheme(
                theme = currentTheme
            ) {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    NavGraph(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding),
                        themeViewModel = themeViewModel
                    )
                }
            }
        }
    }
}