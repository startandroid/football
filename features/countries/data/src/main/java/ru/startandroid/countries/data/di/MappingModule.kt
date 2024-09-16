package ru.startandroid.countries.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.countries.data.mapping.CountryApiToUiMapper
import ru.startandroid.countries.data.network.model.CountryApi
import ru.startandroid.countries.domain.model.Country

@Module
@InstallIn(SingletonComponent::class)
abstract class MappingModule {

    @Binds
    abstract fun bindCountryApiToUiMapper(impl: CountryApiToUiMapper): Mapper<CountryApi, Country>

}