package ru.startandroid.standings.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.startandroid.standings.data.repository.StandingRepositoryImpl
import ru.startandroid.standings.domain.usecase.GetStandingsUseCase

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetStandingsUseCase(impl: StandingRepositoryImpl): GetStandingsUseCase

}