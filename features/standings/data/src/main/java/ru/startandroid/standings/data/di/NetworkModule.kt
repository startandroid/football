package ru.startandroid.standings.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.startandroid.standings.data.network.StandingApiService

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesStandingApi(retrofit: Retrofit): StandingApiService {
        return retrofit.create(StandingApiService::class.java)
    }

}