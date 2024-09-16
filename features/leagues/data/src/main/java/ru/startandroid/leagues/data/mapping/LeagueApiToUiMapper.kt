package ru.startandroid.leagues.data.mapping

import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.leagues.data.network.model.LeagueApi
import ru.startandroid.leagues.domain.model.League
import javax.inject.Inject

class LeagueApiToUiMapper @Inject constructor() : Mapper<LeagueApi, League> {
    override fun map(from: LeagueApi): League {
        return League(
            id = from.league.id,
            name = from.league.name,
            logo = from.league.logo,
            seasons = from.seasons.map { League.Season(it.year) }
        )
    }

}