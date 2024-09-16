package ru.startandroid.leagues.view.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.leagues.api.model.LeagueExt
import ru.startandroid.leagues.domain.model.League
import ru.startandroid.leagues.view.mapping.LeagueUiToExtMapper

@Module
@InstallIn(SingletonComponent::class)
abstract class MappingModule {

    @Binds
    abstract fun bindLeagueUiToExtMapper(impl: LeagueUiToExtMapper): Mapper<League, LeagueExt>
}