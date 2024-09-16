package ru.startandroid.players.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.players.data.mapping.PlayerApiToUiMapper
import ru.startandroid.players.data.network.model.PlayerApi
import ru.startandroid.players.domain.model.Player

@Module
@InstallIn(SingletonComponent::class)
abstract class MappingModule {

    @Binds
    abstract fun bindPlayerApiToUiMapper(impl: PlayerApiToUiMapper): Mapper<PlayerApi, Player>

}