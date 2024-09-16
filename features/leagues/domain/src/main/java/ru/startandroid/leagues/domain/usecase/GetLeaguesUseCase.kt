package ru.startandroid.leagues.domain.usecase

import ru.startandroid.core.common.model.DataResult
import ru.startandroid.leagues.domain.model.League

interface GetLeaguesByCountryUseCase {
    suspend fun getLeaguesByCountry(countryCode: String): DataResult<List<League>>
}

suspend operator fun GetLeaguesByCountryUseCase.invoke(countryCode: String): DataResult<List<League>> = this.getLeaguesByCountry(countryCode)