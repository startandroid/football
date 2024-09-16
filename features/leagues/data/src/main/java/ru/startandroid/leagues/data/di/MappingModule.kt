package ru.startandroid.leagues.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.leagues.data.mapping.LeagueApiToUiMapper
import ru.startandroid.leagues.data.network.model.LeagueApi
import ru.startandroid.leagues.data.network.model.LeaguesResponse
import ru.startandroid.leagues.domain.model.League

@Module
@InstallIn(SingletonComponent::class)
abstract class MappingModule {

    @Binds
    abstract fun bindLeagueApiToUiMapper(impl: LeagueApiToUiMapper): Mapper<LeagueApi, League>

}