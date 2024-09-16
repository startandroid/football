package ru.startandroid.leagues.view.ui.leagues

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.startandroid.core.navigation.SetResult
import ru.startandroid.core.ui.components.uistate.ShowUiState
import ru.startandroid.leagues.api.constants.LEAGUES_NAV_ARG_LEAGUE

@Composable
fun LeaguesScreen(
    navController: NavController,
    viewModel: LeaguesViewModel = hiltViewModel()
) {

    navController.SetResult(LEAGUES_NAV_ARG_LEAGUE, viewModel.selectedLeague)

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Leagues",
            fontSize = 20.sp,
            modifier = Modifier.align(CenterHorizontally)
        )
        val leagueType = viewModel.leagueType.collectAsState().value
        Filter(
            selectedLeagueType = leagueType,
            onLeagueTypeSelected = viewModel::onLeagueTypeChange,
        )

        Leagues(viewModel)
    }
}

@Composable
private fun Leagues(
    holder: LeaguesHolder
) {
    ShowUiState(
        uiStateData = holder.leagues,
    ) { data ->
        LazyColumn() {
            items(data) {
                Text(
                    text = it.name,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .clickable { holder.onLeagueClick(it) }
                        .padding(16.dp)
                )
            }
        }
    }
}

@Composable
private fun Filter(
    selectedLeagueType: LeaguesViewModel.LeagueType,
    onLeagueTypeSelected: (LeaguesViewModel.LeagueType) -> Unit,
) {
    Row {
        LeagueTypeRadioButton(
            type = LeaguesViewModel.LeagueType.LEAGUES,
            selectedType = selectedLeagueType,
            onTypeSelected = onLeagueTypeSelected
        )
        Spacer(modifier = Modifier.width(32.dp))
        LeagueTypeRadioButton(
            type = LeaguesViewModel.LeagueType.CUPS,
            selectedType = selectedLeagueType,
            onTypeSelected = onLeagueTypeSelected
        )
    }
}

@Composable
private fun LeagueTypeRadioButton(
    type: LeaguesViewModel.LeagueType,
    selectedType: LeaguesViewModel.LeagueType,
    onTypeSelected: (LeaguesViewModel.LeagueType) -> Unit
) {
    Row(
        verticalAlignment = CenterVertically,
        modifier = Modifier.clickable { onTypeSelected(type) }
    ) {
        RadioButton(selected = type == selectedType, onClick = { onTypeSelected(type) })
        Text(text = type.name)
    }
}