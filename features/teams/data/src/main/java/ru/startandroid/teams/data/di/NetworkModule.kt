package ru.startandroid.teams.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.startandroid.teams.data.network.TeamsApiService

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesTeamsApiService(retrofit: Retrofit): TeamsApiService {
        return retrofit.create(TeamsApiService::class.java)
    }

}