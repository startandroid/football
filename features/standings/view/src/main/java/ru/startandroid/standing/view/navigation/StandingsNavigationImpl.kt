package ru.startandroid.standing.view.navigation

import ru.startandroid.core.navigation.Navigator
import ru.startandroid.standing.api.navigation.StandingsNavigation
import ru.startandroid.standing.view.ui.standings.StandingsNavScreen
import javax.inject.Inject

class StandingsNavigationImpl @Inject constructor(
    private val navigator: Navigator
): StandingsNavigation {

    override fun openStandings() {
        navigator.navigateTo(StandingsNavScreen.ROUTE)
    }
}