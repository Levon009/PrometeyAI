package com.xxlionxx.prometey.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.xxlionxx.prometey.presentation.ThemeViewModel
import com.xxlionxx.prometey.presentation.screens.AboutScreen
import com.xxlionxx.prometey.presentation.screens.HomeScreen
import com.xxlionxx.prometey.presentation.screens.PrivacyPolicyScreen
import com.xxlionxx.prometey.presentation.screens.ProfileScreen
import com.xxlionxx.prometey.presentation.screens.SettingsScreen
import com.xxlionxx.prometey.presentation.screens.ThemeScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    themeViewModel: ThemeViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home,
        modifier = modifier,

        enterTransition = {
            fadeIn(tween(300))
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.End,
                tween(300)
            )
        },
        exitTransition = {
            fadeOut(tween(300))
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Start,
                tween(300)
            )
        }
    ) {
        composable<Routes.Home> {
            HomeScreen(
                navController = navController
            )
        }

        composable<Routes.Profile> {
            ProfileScreen()
        }

        composable<Routes.Theme> {
            ThemeScreen(
                viewModel = themeViewModel
            )
        }

        composable<Routes.About> {
            AboutScreen()
        }

        composable<Routes.Settings> {
            SettingsScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable<Routes.PrivacyPolicy> {
            PrivacyPolicyScreen()
        }
    }
}