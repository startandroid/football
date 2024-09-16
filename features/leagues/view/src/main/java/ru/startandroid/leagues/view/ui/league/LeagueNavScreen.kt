package ru.startandroid.leagues.view.ui.league

import androidx.compose.runtime.Composable
import ru.startandroid.core.navigation.NavScreen
import ru.startandroid.core.navigation.NavigationContext
import javax.inject.Inject

class LeagueNavScreen @Inject constructor(): NavScreen {

    override val route = buildRoute("{$NAV_ARG_LEAGUE_ID}")

    @Composable
    override fun Content(context: NavigationContext) {
        LeagueScreen(
            navController = context.navController
        )
    }

    companion object {
        const val ROUTE = "league"
        const val NAV_ARG_LEAGUE_ID = "leagueId"
        fun buildRoute(leagueId: String) = "$ROUTE/$leagueId"

    }

}