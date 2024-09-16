package ru.startandroid.leagues.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.startandroid.leagues.data.network.LeaguesApiService

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesLeaguesApi(retrofit: Retrofit): LeaguesApiService {
        return retrofit.create(LeaguesApiService::class.java)
    }

}