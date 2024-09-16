package ru.startandroid.teams.domain.repository

import ru.startandroid.teams.domain.usecase.GetTeamSeasonsUseCase
import ru.startandroid.teams.domain.usecase.GetTeamUseCase

interface TeamsRepository: GetTeamUseCase, GetTeamSeasonsUseCase
