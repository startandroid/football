package ru.startandroid.standing.view.ui.standings

import androidx.compose.runtime.Stable
import ru.startandroid.core.ui.components.uistate.UiStateData
import ru.startandroid.standings.domain.model.Standing

@Stable
interface StandingsHolder {
    val standings: UiStateData<List<Standing>>
    fun onTeamClick(teamId: Int): Unit
}