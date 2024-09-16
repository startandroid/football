package ru.startandroid.standings.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.standings.data.mapping.StandingApiToUiMapper
import ru.startandroid.standings.data.network.model.StandingApi
import ru.startandroid.standings.domain.model.Standing

@Module
@InstallIn(SingletonComponent::class)
abstract class MappingModule {

    @Binds
    abstract fun bindStandingApiToUiMapper(standingApiToUiMapper: StandingApiToUiMapper): Mapper<StandingApi, Standing>

}