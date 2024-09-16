package ru.startandroid.leagues.domain.usecase

import ru.startandroid.core.common.model.DataResult
import ru.startandroid.leagues.domain.model.League

interface GetLeagueByIdUseCase {
    suspend fun getLeagueById(leagueId: Int): DataResult<League>
}

suspend operator fun GetLeagueByIdUseCase.invoke(leagueId: Int): DataResult<League> =
    this.getLeagueById(leagueId = leagueId)