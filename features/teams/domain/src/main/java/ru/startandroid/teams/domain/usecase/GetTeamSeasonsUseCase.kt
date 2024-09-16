package ru.startandroid.teams.domain.usecase

import ru.startandroid.core.common.model.DataResult

interface GetTeamSeasonsUseCase {
    suspend fun getSeasons(team: Int): DataResult<List<String>>
}

suspend operator fun GetTeamSeasonsUseCase.invoke(team: Int) = getSeasons(team)