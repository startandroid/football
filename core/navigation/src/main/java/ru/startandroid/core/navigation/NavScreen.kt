package ru.startandroid.core.navigation

import androidx.compose.runtime.Composable

interface NavScreen {

    val route: String

    @Composable
    fun Content(context: NavigationContext)
}