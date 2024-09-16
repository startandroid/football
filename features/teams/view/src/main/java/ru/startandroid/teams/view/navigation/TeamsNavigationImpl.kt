package ru.startandroid.teams.view.navigation

import ru.startandroid.core.navigation.Navigator
import ru.startandroid.teams.api.navigation.TeamsNavigation
import ru.startandroid.teams.view.ui.team.TeamNavScreen
import javax.inject.Inject

class TeamsNavigationImpl @Inject constructor(
    private val navigator: Navigator
) : TeamsNavigation {

    override fun openTeam(teamId: String) {
        navigator.navigateTo(TeamNavScreen.buildRoute(teamId))
    }

}