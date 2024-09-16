package ru.startandroid.teams.domain.usecase

import ru.startandroid.core.common.model.DataResult
import ru.startandroid.teams.domain.model.Team

interface GetTeamUseCase {
    suspend fun getTeam(teamId: Int): DataResult<Team>
}

suspend operator fun GetTeamUseCase.invoke(teamId: Int): DataResult<Team> =
    this.getTeam(teamId = teamId)