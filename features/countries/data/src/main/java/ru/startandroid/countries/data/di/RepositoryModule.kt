package ru.startandroid.countries.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.startandroid.countries.data.repository.CountriesRepositoryImpl
import ru.startandroid.countries.domain.repository.CountriesRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsCountriesRepository(countriesRepositoryImpl: CountriesRepositoryImpl): CountriesRepository
}