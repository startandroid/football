package ru.startandroid.leagues.view.ui.league

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.startandroid.core.navigation.SetResult
import ru.startandroid.core.ui.components.uistate.ShowUiState
import ru.startandroid.leagues.api.constants.LEAGUES_NAV_ARG_SEASON

@Composable
fun LeagueScreen(
    navController: NavController,
    viewModel: LeagueViewModel = hiltViewModel()
) {
    navController.SetResult(LEAGUES_NAV_ARG_SEASON, viewModel.selectedSeason)
    Column {
        Text("League")

        ShowUiState(
            uiStateData = viewModel.league
        ) { league ->
            Column {
                Text(text = league.name)
                Text(text = "Seasons")
                LazyColumn {
                    items(league.seasons) { season ->
                        Text(
                            text = season.year.toString(),
                            fontSize = 20.sp,
                            modifier = Modifier.clickable { viewModel.onSeasonClick(season.year) }
                        )
                    }
                }
            }
        }
    }

}