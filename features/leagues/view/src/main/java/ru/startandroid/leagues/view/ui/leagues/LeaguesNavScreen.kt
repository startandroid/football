package ru.startandroid.leagues.view.ui.leagues

import androidx.compose.runtime.Composable
import ru.startandroid.core.navigation.NavScreen
import ru.startandroid.core.navigation.NavigationContext
import javax.inject.Inject

class LeaguesNavScreen @Inject constructor() : NavScreen {
    override val route: String = buildRoute("{$NAV_ARG_COUNTRY_CODE}")

    @Composable
    override fun Content(context: NavigationContext) {
        LeaguesScreen(navController = context.navController)
    }

    companion object {
        const val ROUTE = "leagues"
        const val NAV_ARG_COUNTRY_CODE = "countryCode"
        fun buildRoute(countryCode: String) = "$ROUTE/$countryCode"

    }

}