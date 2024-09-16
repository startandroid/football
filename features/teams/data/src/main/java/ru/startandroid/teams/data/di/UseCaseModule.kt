package ru.startandroid.teams.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.startandroid.teams.data.repository.TeamsRepositoryImpl
import ru.startandroid.teams.domain.usecase.GetTeamSeasonsUseCase
import ru.startandroid.teams.domain.usecase.GetTeamUseCase

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindsGetTeamsUseCase(impl: TeamsRepositoryImpl): GetTeamUseCase

    @Binds
    abstract fun bindsGetTeamSeasonsUseCase(impl: TeamsRepositoryImpl): GetTeamSeasonsUseCase

}