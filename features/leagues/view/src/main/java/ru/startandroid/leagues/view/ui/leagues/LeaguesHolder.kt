package ru.startandroid.leagues.view.ui.leagues

import androidx.compose.runtime.Stable
import ru.startandroid.core.ui.components.uistate.UiStateData
import ru.startandroid.leagues.domain.model.League

@Stable
interface LeaguesHolder {
    val leagues: UiStateData<List<League>>
    fun onLeagueClick(league: League)
}