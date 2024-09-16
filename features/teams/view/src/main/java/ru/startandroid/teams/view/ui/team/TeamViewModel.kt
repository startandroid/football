package ru.startandroid.teams.view.ui.team

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.startandroid.core.ui.components.uistate.UiStateData
import ru.startandroid.players.api.navigation.PlayersNavigation
import ru.startandroid.teams.domain.usecase.GetTeamUseCase
import ru.startandroid.teams.domain.usecase.invoke
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val getTeamUseCase: GetTeamUseCase,
    private val playersNavigation: PlayersNavigation,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val teamId: String = checkNotNull(savedStateHandle[TeamNavScreen.NAV_ARG_TEAM_ID])
    val team = UiStateData { getTeamUseCase(teamId.toInt()) }

    fun onPlayersClick() {
        playersNavigation.openPlayers(teamId = teamId.toInt())
    }
}
