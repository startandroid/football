package ru.startandroid.players.domain.usecase

import ru.startandroid.core.common.model.DataResult
import ru.startandroid.players.domain.model.Player

interface GetPlayersUseCase {
    suspend fun getPlayers(teamId: Int, season: Int, page: Int): DataResult<List<Player>>
}

suspend operator fun GetPlayersUseCase.invoke(teamId: Int, season: Int, page: Int): DataResult<List<Player>> =
    this.getPlayers(teamId = teamId, season = season, page = page)