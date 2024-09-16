package ru.startandroid.teams.data.mapping

import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.teams.data.network.model.TeamApi
import ru.startandroid.teams.domain.model.Team
import javax.inject.Inject

class TeamApiToUiMapper @Inject constructor() : Mapper<TeamApi, Team> {
    override fun map(from: TeamApi): Team {
        return Team(
            id = from.team.id,
            name = from.team.name,
            logo = from.team.logo,
            country = from.team.country,
            venue = Team.Venue(
                id = from.venue.id,
                name = from.venue.name,
                city = from.venue.city
            )
        )
    }
}