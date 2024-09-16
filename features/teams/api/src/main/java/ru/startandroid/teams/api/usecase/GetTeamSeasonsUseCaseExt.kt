package ru.startandroid.teams.api.usecase

import ru.startandroid.core.common.model.DataResult

interface GetTeamSeasonsUseCaseExt {
    suspend operator fun invoke(team: Int): DataResult<List<String>>
}