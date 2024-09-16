package ru.startandroid.teams.domain.usecase

import ru.startandroid.core.common.model.DataResult
import javax.inject.Inject
import ru.startandroid.teams.api.usecase.GetTeamSeasonsUseCaseExt

class GetTeamSeasonsUseCaseExtImpl @Inject constructor(
    private val getTeamSeasonsUseCase: GetTeamSeasonsUseCase
): GetTeamSeasonsUseCaseExt {
    override suspend operator fun invoke(team: Int): DataResult<List<String>> {
        return getTeamSeasonsUseCase(team)
    }

}