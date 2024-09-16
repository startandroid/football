package ru.startandroid.players.view.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
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
import androidx.compose.ui.window.Popup
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import ru.startandroid.core.ui.components.asyncimage.rememberImageRequest
import ru.startandroid.core.ui.components.uistate.ShowUiState
import ru.startandroid.core.ui.components.uistate.ShowUiStatePaged
import ru.startandroid.players.domain.model.Player


@Composable
fun PlayersScreen(
    viewModel: PlayersViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        ShowUiState(
            uiStateData = viewModel.seasons
        ) { seasons ->
            Column(modifier = Modifier.fillMaxSize()) {
                SeasonPopup(
                    seasons = seasons,
                    selectedSeason = viewModel.selectedSeason.collectAsState().value?.toString(),
                    onSeasonSelected = viewModel::onSeasonSelected
                )
                ShowUiStatePaged(uiStatePagedData = viewModel.players) { player ->
                    Player(player)
                }
            }
        }
    }
}

@Composable
fun SeasonPopup(
    seasons: List<String>,
    selectedSeason: String?,
    onSeasonSelected: (String) -> Unit
) {
    Column(Modifier.fillMaxWidth()) {
        var showPopup by remember { mutableStateOf(false) }
        Text(text = "Choose season ${selectedSeason.orEmpty()}", modifier = Modifier.fillMaxWidth().clickable { showPopup = true })
        Box {
            if (showPopup) {
                Popup(
                    onDismissRequest = { showPopup = false }
                ) {
                    Surface(
                        shadowElevation = 2.dp,
                        modifier = Modifier.width(150.dp).height(400.dp)
                    ) {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(seasons) { season ->
                                Text(text = season, modifier = Modifier.fillMaxWidth()
                                    .clickable {
                                        showPopup = false
                                        onSeasonSelected(season)
                                    }
                                    .padding(8.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Player(
    player: Player,
) {
    Column(modifier = Modifier
        .padding(8.dp)
        .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
        .fillMaxWidth()
        .padding(8.dp)
    ) {
        Row(verticalAlignment = CenterVertically) {
            Box(modifier = Modifier.padding(end = 16.dp).size(96.dp)) {
                player.photo?.let {
                    AsyncImage(
                        model = rememberImageRequest(it),
                        contentDescription = "player photo",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            Column() {
                Text(text = player.name, fontSize = 20.sp)
                Text(text = player.nationality, fontSize = 16.sp)
                Text(text = "${player.age} years old", fontSize = 16.sp)
                Text(text = player.height, fontSize = 16.sp)
                Text(text = player.weight, fontSize = 16.sp)
            }
        }
    }
}