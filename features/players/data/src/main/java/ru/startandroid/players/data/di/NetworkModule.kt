package ru.startandroid.players.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.startandroid.players.data.network.PlayersApiService

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesPlayersApiService(retrofit: Retrofit): PlayersApiService {
        return retrofit.create(PlayersApiService::class.java)
    }

}