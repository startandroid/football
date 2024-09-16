package ru.startandroid.leagues.view.ui.league

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.startandroid.core.ui.components.uistate.UiStateData
import ru.startandroid.leagues.domain.usecase.GetLeagueByIdUseCase
import ru.startandroid.leagues.domain.usecase.invoke
import javax.inject.Inject

@HiltViewModel
class LeagueViewModel @Inject constructor(
    private val getLeagueByIdUseCase: GetLeagueByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val leagueId: String = checkNotNull(savedStateHandle[LeagueNavScreen.NAV_ARG_LEAGUE_ID])
    val league = UiStateData { getLeagueByIdUseCase(leagueId = leagueId.toInt()) }

    private val _selectedSeason = MutableStateFlow<Int?>(null)
    val selectedSeason = _selectedSeason.asStateFlow()

    fun onSeasonClick(year: Int) {
        _selectedSeason.value = year
    }
}