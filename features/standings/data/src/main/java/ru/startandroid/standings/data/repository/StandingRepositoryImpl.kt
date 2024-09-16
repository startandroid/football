package ru.startandroid.standings.data.repository

import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.core.common.model.DataResult
import ru.startandroid.standings.data.network.StandingApiService
import ru.startandroid.standings.data.network.model.StandingApi
import ru.startandroid.standings.domain.model.Standing
import ru.startandroid.standings.domain.repository.StandingRepository
import java.util.logging.Logger
import javax.inject.Inject

class StandingRepositoryImpl @Inject constructor(
    private val standingApiService: StandingApiService,
    private val apiToUiMapper: Mapper<StandingApi, Standing>
) : StandingRepository {

    override suspend fun getStandings(league: Int, season: Int): DataResult<List<Standing>> {
        return standingApiService.getStandings(
            league = league,
            season = season
        ).map {
            it.response.firstOrNull()?.league?.standings?.firstOrNull()
                ?.map { item -> apiToUiMapper.map(item) }
                .orEmpty()
        }
    }
}