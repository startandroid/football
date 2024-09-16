package ru.startandroid.leagues.view.mapping

import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.leagues.api.model.LeagueExt
import ru.startandroid.leagues.domain.model.League
import javax.inject.Inject

class LeagueUiToExtMapper @Inject constructor() : Mapper<League, LeagueExt> {
    override fun map(from: League): LeagueExt {
        return LeagueExt(
            id = from.id,
            name = from.name
        )
    }
}