package ru.startandroid.football.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.startandroid.core.di.Debug
import ru.startandroid.football.BuildConfig

@Module
@InstallIn(SingletonComponent::class)
class ConstantModule {

    @Debug
    @Provides
    fun providesIsDebug(): Boolean {
        return BuildConfig.DEBUG
    }

}