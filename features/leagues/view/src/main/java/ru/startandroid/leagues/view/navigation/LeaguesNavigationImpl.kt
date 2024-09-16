package ru.startandroid.leagues.view.navigation

import ru.startandroid.core.navigation.Navigator
import ru.startandroid.leagues.api.navigation.LeaguesNavigation
import ru.startandroid.leagues.view.ui.league.LeagueNavScreen
import ru.startandroid.leagues.view.ui.leagues.LeaguesNavScreen
import javax.inject.Inject

class LeaguesNavigationImpl @Inject constructor(
    private val navigator: Navigator
): LeaguesNavigation {
    override fun chooseLeague(countryCode: String) {
        navigator.navigateTo(LeaguesNavScreen.buildRoute(countryCode = countryCode))
    }

    override fun chooseSeason(leagueId: String) {
        navigator.navigateTo(LeagueNavScreen.buildRoute(leagueId = leagueId))
    }
}