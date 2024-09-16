package ru.startandroid.standings.domain.usecase

import ru.startandroid.core.common.model.DataResult
import ru.startandroid.standings.domain.model.Standing

interface GetStandingsUseCase {
    suspend fun getStandings(league: Int, season: Int): DataResult<List<Standing>>
}

suspend operator fun GetStandingsUseCase.invoke(league: Int, season: Int): DataResult<List<Standing>> =
    this.getStandings(league = league, season = season)