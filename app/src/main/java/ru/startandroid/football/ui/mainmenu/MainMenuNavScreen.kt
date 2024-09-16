package ru.startandroid.football.ui.mainmenu

import androidx.compose.runtime.Composable
import ru.startandroid.core.navigation.NavScreen
import ru.startandroid.core.navigation.NavigationContext
import javax.inject.Inject

class MainMenuNavScreen @Inject constructor() : NavScreen {
    override val route: String = ROUTE

    @Composable
    override fun Content(context: NavigationContext) {
        MainMenuScreen()
    }

    companion object {
        const val ROUTE = "main_menu"
    }

}