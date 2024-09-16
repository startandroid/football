package ru.startandroid.teams.view.ui.team

import androidx.compose.runtime.Composable
import ru.startandroid.core.navigation.NavScreen
import ru.startandroid.core.navigation.NavigationContext
import javax.inject.Inject

class TeamNavScreen @Inject constructor(): NavScreen {

    override val route = buildRoute("{$NAV_ARG_TEAM_ID}")

    @Composable
    override fun Content(context: NavigationContext) {
        TeamScreen()
    }

    companion object {
        const val ROUTE = "team"
        const val NAV_ARG_TEAM_ID = "teamId"
        fun buildRoute(teamId: String) = "$ROUTE/$teamId"
    }

}