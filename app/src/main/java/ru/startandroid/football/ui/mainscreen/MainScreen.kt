package ru.startandroid.football.ui.mainscreen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.startandroid.core.navigation.NavigateTo
import ru.startandroid.core.navigation.NavigationContext
import ru.startandroid.football.ui.mainmenu.MainMenuNavScreen
import ru.startandroid.standing.api.constants.STANDINGS_NAV_ROUTE_STANDINGS

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val navController = rememberNavController()
        Box(Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = STANDINGS_NAV_ROUTE_STANDINGS
            ) {
                viewModel.navScreens.forEach { screen ->
                    composable(screen.route) {
                        screen.Content(NavigationContext(navController))
                    }
                }
            }
        }
        LaunchedEffect(Unit) {
            viewModel.navigator.events.collect { event ->
                when (event) {
                    is NavigateTo -> navController.navigate(event.route)
                    else -> Unit
                }
            }
        }
    }
}