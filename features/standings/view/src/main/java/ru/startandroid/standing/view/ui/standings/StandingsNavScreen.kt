package ru.startandroid.standing.view.ui.standings

import androidx.compose.runtime.Composable
import ru.startandroid.core.navigation.NavScreen
import ru.startandroid.core.navigation.NavigationContext
import ru.startandroid.standing.api.constants.STANDINGS_NAV_ROUTE_STANDINGS
import javax.inject.Inject

class StandingsNavScreen @Inject constructor(): NavScreen {
    override val route = ROUTE

    @Composable
    override fun Content(context: NavigationContext) {
        StandingsScreen(
            navController = context.navController
        )
    }

    companion object {
        const val ROUTE = STANDINGS_NAV_ROUTE_STANDINGS
    }

}