package ru.startandroid.teams.data.repository

import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.core.common.model.DataResult
import ru.startandroid.teams.data.network.TeamsApiService
import ru.startandroid.teams.data.network.model.TeamApi
import ru.startandroid.teams.domain.model.Team
import ru.startandroid.teams.domain.repository.TeamsRepository
import javax.inject.Inject

class TeamsRepositoryImpl @Inject constructor(
    private val teamsApiService: TeamsApiService,
    private val apiToUiMapper: Mapper<TeamApi, Team>
): TeamsRepository {

    override suspend fun getTeam(teamId: Int): DataResult<Team> {
        return teamsApiService.getTeams(teamId).map {
            it.response.firstOrNull()?.let { item -> apiToUiMapper.map(item) }
        }
    }

    override suspend fun getSeasons(team: Int): DataResult<List<String>> {
        return teamsApiService.getSeasons(team).map {
            it.response
        }
    }
}