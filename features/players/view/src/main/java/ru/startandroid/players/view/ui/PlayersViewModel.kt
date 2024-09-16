package ru.startandroid.players.view.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.startandroid.core.ui.components.uistate.UiStateData
import ru.startandroid.core.ui.components.uistate.UiStatePagedData
import ru.startandroid.players.domain.usecase.GetPlayersUseCase
import ru.startandroid.players.domain.usecase.invoke
import ru.startandroid.teams.api.usecase.GetTeamSeasonsUseCaseExt
import javax.inject.Inject

@HiltViewModel
class PlayersViewModel @Inject constructor(
    private val getPlayersUseCase: GetPlayersUseCase,
    private val getTeamSeasonsUseCase: GetTeamSeasonsUseCaseExt,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val teamId: String = checkNotNull(savedStateHandle[PlayersNavScreen.NAV_ARG_TEAM_ID])

    val seasons = UiStateData { getTeamSeasonsUseCase(teamId.toInt()).map { it.sortedDescending() } }

    private val _selectedSeason = MutableStateFlow<Int?>(null)
    val selectedSeason = _selectedSeason.asStateFlow()

    val players = UiStatePagedData { page ->
        val season = selectedSeason.value ?: return@UiStatePagedData null
        getPlayersUseCase(teamId.toInt(), season, page)
    }

    fun onSeasonSelected(season: String) {
        _selectedSeason.value = season.toInt()
        players.refresh()
    }

}