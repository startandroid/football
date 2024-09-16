package ru.startandroid.teams.view.ui.team

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import ru.startandroid.core.ui.components.asyncimage.rememberImageRequest
import ru.startandroid.core.ui.components.uistate.ShowUiState

@Composable
fun TeamScreen(
    viewModel: TeamViewModel = hiltViewModel()
) {
    ShowUiState(uiStateData = viewModel.team) { team ->
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            AsyncImage(
                model = rememberImageRequest(team.logo),
                contentDescription = "team logo",
                modifier = Modifier.padding(vertical = 8.dp).size(192.dp).align(Alignment.CenterHorizontally)
            )
            Text(text = team.name, fontSize = 20.sp)
            Text(text = team.country, fontSize = 18.sp)
            Text(text = "${team.venue.name} (${team.venue.city})", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = viewModel::onPlayersClick) {
                Text(text = "Players")
            }
        }
    }
}