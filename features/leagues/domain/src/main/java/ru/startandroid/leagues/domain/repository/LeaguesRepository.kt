package ru.startandroid.leagues.domain.repository

import ru.startandroid.core.common.model.DataResult
import ru.startandroid.leagues.domain.model.League
import ru.startandroid.leagues.domain.usecase.GetCupsByCountryUseCase
import ru.startandroid.leagues.domain.usecase.GetLeagueByIdUseCase
import ru.startandroid.leagues.domain.usecase.GetLeaguesByCountryUseCase

interface LeaguesRepository:
    GetCupsByCountryUseCase,
    GetLeaguesByCountryUseCase,
    GetLeagueByIdUseCase
