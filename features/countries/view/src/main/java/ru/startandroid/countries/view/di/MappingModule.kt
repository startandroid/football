package ru.startandroid.countries.view.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.countries.api.model.CountryExt
import ru.startandroid.countries.domain.model.Country
import ru.startandroid.countries.view.mapping.CountryUiToExtMapper

@InstallIn(SingletonComponent::class)
@Module
abstract class MappingModule {

    @Binds
    abstract fun bindCountryUiToExtMapper(impl: CountryUiToExtMapper): Mapper<Country, CountryExt>

}