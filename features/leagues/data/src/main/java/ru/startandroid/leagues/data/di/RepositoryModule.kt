package ru.startandroid.leagues.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.startandroid.leagues.data.repository.LeaguesRepositoryImpl
import ru.startandroid.leagues.domain.repository.LeaguesRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsLeagueRepository(leaguesRepositoryImpl: LeaguesRepositoryImpl): LeaguesRepository

}