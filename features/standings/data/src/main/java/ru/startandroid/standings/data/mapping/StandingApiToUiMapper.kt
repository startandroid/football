package ru.startandroid.standings.data.mapping

import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.standings.data.network.model.StandingApi
import ru.startandroid.standings.domain.model.Standing
import javax.inject.Inject

class StandingApiToUiMapper @Inject constructor() : Mapper<StandingApi, Standing> {

    override fun map(from: StandingApi): Standing {
        return Standing(
            rank = from.rank,
            team = Standing.Team(
                id = from.team.id,
                name = from.team.name,
                logo = from.team.logo
            ),
            points = from.points,
            goalsDiff = from.goalsDiff,
            stats = Standing.Stats(
                played = from.all.played,
                win = from.all.win,
                draw = from.all.draw,
                lose = from.all.lose,
                goals = Standing.Stats.Goals(
                    forx = from.all.goals.forx,
                    against = from.all.goals.against
                )
            )
        )
    }
}