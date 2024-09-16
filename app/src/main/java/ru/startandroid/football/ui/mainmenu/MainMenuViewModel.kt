package ru.startandroid.football.ui.mainmenu

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.startandroid.leagues.api.navigation.LeaguesNavigation
import ru.startandroid.standing.api.navigation.StandingsNavigation
import javax.inject.Inject

@HiltViewModel
class MainMenuViewModel @Inject constructor(
    private val standingsNavigation: StandingsNavigation
): ViewModel()  {

    fun onStandingsClick() {
        standingsNavigation.openStandings()
    }

}