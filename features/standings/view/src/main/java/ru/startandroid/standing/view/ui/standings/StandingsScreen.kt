package ru.startandroid.standing.view.ui.standings

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import ru.startandroid.core.navigation.GetResult
import ru.startandroid.core.ui.components.asyncimage.rememberImageRequest
import ru.startandroid.core.ui.components.uistate.ShowUiState
import ru.startandroid.countries.api.constants.COUNTRIES_NAV_ARG_COUNTRY
import ru.startandroid.leagues.api.constants.LEAGUES_NAV_ARG_LEAGUE
import ru.startandroid.leagues.api.constants.LEAGUES_NAV_ARG_SEASON
import ru.startandroid.standings.domain.model.Standing

@Composable
fun StandingsScreen(
    navController: NavController,
    viewModel: StandingsViewModel = hiltViewModel()
) {
    navController.GetResult(COUNTRIES_NAV_ARG_COUNTRY, viewModel::onCountryChosen)
    navController.GetResult(LEAGUES_NAV_ARG_LEAGUE, viewModel::onLeagueChosen)
    navController.GetResult(LEAGUES_NAV_ARG_SEASON, viewModel::onSeasonChosen)

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        val country = viewModel.country.collectAsState().value
        Text(
            text = "Choose country: ${country?.name.orEmpty()}",
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth()
                .clickable(onClick = viewModel::onCountryClick)
                .padding(8.dp)
        )
        if (country == null) return

        val league = viewModel.league.collectAsState()
        Text(
            text = "Choose league: ${league.value?.name.orEmpty()}",
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth()
                .clickable(onClick = viewModel::onLeagueClick)
                .padding(8.dp)
        )
        if (league.value == null) return

        val season = viewModel.season.collectAsState()
        Text(
            text = "Choose season: ${season.value?.toString().orEmpty()}",
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth()
                .clickable(onClick = viewModel::onSeasonClick)
                .padding(8.dp)
        )
        if (season.value == null) return

        Standings(viewModel)
    }
}

@Composable
private fun Standings(
    holder: StandingsHolder,
) {
    ShowUiState(holder.standings) { standingItems ->
        LazyColumn {
            items(standingItems) {
                Standing(
                    standing = it,
                    onTeamClick = holder::onTeamClick
                )
            }
        }
    }
}

@Composable
private fun Standing(
    standing: Standing,
    onTeamClick: (Int) -> Unit
) {
    Column(modifier = Modifier
        .clickable { onTeamClick(standing.team.id) }
        .padding(8.dp)
        .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
        .fillMaxWidth()
        .padding(8.dp)
    ) {
        Text(text = "${standing.rank}. Points: ${standing.points}. G: ${standing.stats.goals.forx} - ${standing.stats.goals.against}.  W: ${standing.stats.win}. D: ${standing.stats.draw}. L: ${standing.stats.lose}")
        HorizontalDivider()
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = CenterVertically,
        ) {
            AsyncImage(
                model = rememberImageRequest(standing.team.logo),
                contentDescription = "team logo",
                modifier = Modifier.size(48.dp).padding(end = 8.dp)
            )
            Text(text = standing.team.name, fontSize = 20.sp)
        }
    }
}