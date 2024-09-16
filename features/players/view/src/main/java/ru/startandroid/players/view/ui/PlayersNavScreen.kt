package ru.startandroid.players.view.ui

import androidx.compose.runtime.Composable
import ru.startandroid.core.navigation.NavScreen
import ru.startandroid.core.navigation.NavigationContext
import javax.inject.Inject

class PlayersNavScreen @Inject constructor(): NavScreen {

    override val route = buildRoute(teamId = "{$NAV_ARG_TEAM_ID}")

    @Composable
    override fun Content(context: NavigationContext) {
        PlayersScreen()
    }

    companion object {
        const val ROUTE = "players"
        const val NAV_ARG_TEAM_ID = "teamId"
        fun buildRoute(teamId: String) = "$ROUTE/$teamId"
    }
}