package ru.startandroid.teams.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.startandroid.teams.api.usecase.GetTeamSeasonsUseCaseExt
import ru.startandroid.teams.domain.usecase.GetTeamSeasonsUseCaseExtImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindsGetTeamSeasonsUseCaseExt(impl: GetTeamSeasonsUseCaseExtImpl): GetTeamSeasonsUseCaseExt
}