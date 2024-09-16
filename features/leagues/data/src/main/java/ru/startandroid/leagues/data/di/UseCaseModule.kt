package ru.startandroid.leagues.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.startandroid.leagues.data.repository.LeaguesRepositoryImpl
import ru.startandroid.leagues.domain.usecase.GetCupsByCountryUseCase
import ru.startandroid.leagues.domain.usecase.GetLeagueByIdUseCase
import ru.startandroid.leagues.domain.usecase.GetLeaguesByCountryUseCase

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetLeaguesByCountryUseCase(impl: LeaguesRepositoryImpl): GetLeaguesByCountryUseCase

    @Binds
    abstract fun bindGetCupsByCountryUseCase(impl: LeaguesRepositoryImpl): GetCupsByCountryUseCase

    @Binds
    abstract fun bindGetLeagueByIdUseCase(impl: LeaguesRepositoryImpl): GetLeagueByIdUseCase

}