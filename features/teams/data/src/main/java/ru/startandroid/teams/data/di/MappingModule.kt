package ru.startandroid.teams.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.teams.data.mapping.TeamApiToUiMapper
import ru.startandroid.teams.data.network.model.TeamApi
import ru.startandroid.teams.domain.model.Team

@Module
@InstallIn(SingletonComponent::class)
abstract class MappingModule {

    @Binds
    abstract fun bindsTeamApiToUiMapper(impl: TeamApiToUiMapper): Mapper<TeamApi, Team>

}