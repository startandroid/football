package ru.startandroid.countries.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import ru.startandroid.countries.data.network.CountriesApiService

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun providesCountriesApi(retrofit: Retrofit): CountriesApiService {
        return retrofit.create(CountriesApiService::class.java)
    }

}