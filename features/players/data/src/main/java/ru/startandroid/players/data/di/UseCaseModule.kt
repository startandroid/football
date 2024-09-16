package ru.startandroid.players.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.startandroid.players.data.repository.PlayersRepositoryImpl
import ru.startandroid.players.domain.usecase.GetPlayersUseCase

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindsGetPlayersUseCase(impl: PlayersRepositoryImpl): GetPlayersUseCase

}