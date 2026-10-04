package com.xxlionxx.prometey.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    data object Home : Routes()

    @Serializable
    data object Profile : Routes()

    @Serializable
    data object Theme : Routes()

    @Serializable
    data object About : Routes()

    @Serializable
    data object Settings : Routes()

    @Serializable
    data object PrivacyPolicy : Routes()
}