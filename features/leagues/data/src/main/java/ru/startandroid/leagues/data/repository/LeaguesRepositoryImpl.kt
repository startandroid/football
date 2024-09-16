package ru.startandroid.leagues.data.repository

import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.core.common.model.DataResult
import ru.startandroid.leagues.data.network.model.LeagueApi
import ru.startandroid.leagues.data.network.LeaguesApiService
import ru.startandroid.leagues.data.network.model.LeaguesResponse
import ru.startandroid.leagues.domain.model.League
import ru.startandroid.leagues.domain.repository.LeaguesRepository
import java.util.logging.Logger
import javax.inject.Inject

class LeaguesRepositoryImpl @Inject constructor(
    private val leaguesApiService: LeaguesApiService,
    private val apiToUiMapper: Mapper<LeagueApi, League>
) : LeaguesRepository {

    private val typeCup = "cup"
    private val typeLeague = "league"

    override suspend fun getLeaguesByCountry(countryCode: String): DataResult<List<League>> {
        return getLeagues(countryCode, typeLeague)
    }

    override suspend fun getCupsByCountry(countryCode: String): DataResult<List<League>> {
        return getLeagues(countryCode, typeCup)
    }

    private suspend fun getLeagues(countryCode: String, type: String): DataResult<List<League>> {

        val result = if (countryCode != "##")  {
            leaguesApiService.getLeaguesByCountry(type = type, countryCode = countryCode)
        } else  {
            leaguesApiService.getWorldLeagues(type)
        }

        return result.map { it.response.sortedBy { league -> league.league.id }.map { league -> apiToUiMapper.map(league) } }
    }

    override suspend fun getLeagueById(leagueId: Int): DataResult<League> {
        return leaguesApiService.getLeagueById(leagueId).map { response ->
            response.response.firstOrNull()?.let { league -> apiToUiMapper.map(league) }
        }
    }
}