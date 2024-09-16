package ru.startandroid.leagues.domain.usecase

import ru.startandroid.core.common.model.DataResult
import ru.startandroid.leagues.domain.model.League
import ru.startandroid.leagues.domain.repository.LeaguesRepository
import javax.inject.Inject

interface GetCupsByCountryUseCase {
    suspend fun getCupsByCountry(countryCode: String): DataResult<List<League>>
}

suspend operator fun GetCupsByCountryUseCase.invoke(countryCode: String): DataResult<List<League>> = this.getCupsByCountry(countryCode)