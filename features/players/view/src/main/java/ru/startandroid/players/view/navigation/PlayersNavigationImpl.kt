package ru.startandroid.players.view.navigation

import ru.startandroid.core.navigation.Navigator
import ru.startandroid.players.api.navigation.PlayersNavigation
import ru.startandroid.players.view.ui.PlayersNavScreen
import javax.inject.Inject

class PlayersNavigationImpl @Inject constructor(
    private val navigator: Navigator
) : PlayersNavigation {
    override fun openPlayers(teamId: Int) {
        navigator.navigateTo(PlayersNavScreen.buildRoute(teamId.toString()))
    }
}