package ru.startandroid.players.data.repository

import ru.startandroid.core.common.model.DataResult
import ru.startandroid.players.data.mapping.PlayerApiToUiMapper
import ru.startandroid.players.data.network.PlayersApiService
import ru.startandroid.players.domain.model.Player
import ru.startandroid.players.domain.repository.PlayersRepository
import javax.inject.Inject

class PlayersRepositoryImpl @Inject constructor(
    private val playersApiService: PlayersApiService,
    private val playerApiToUiMapper: PlayerApiToUiMapper
) : PlayersRepository {

    override suspend fun getPlayers(teamId: Int, season: Int, page: Int): DataResult<List<Player>> {
        return playersApiService.getPlayers(teamId, season, page).map {
            it.response.map { playerApi ->
                playerApiToUiMapper.map(playerApi)
            }
        }
    }

}