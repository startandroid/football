package ru.startandroid.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json

@Module
@InstallIn(SingletonComponent::class)
class JsonModule {

    @Provides
    fun providesJson(): Json {
        return Json {
            ignoreUnknownKeys = true
            isLenient = true
        }
    }

}