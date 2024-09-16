package ru.startandroid.countries.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.startandroid.countries.data.repository.CountriesRepositoryImpl
import ru.startandroid.countries.domain.usecase.GetCountriesUseCase

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetCountriesUseCase(impl: CountriesRepositoryImpl): GetCountriesUseCase


}