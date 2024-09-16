package ru.startandroid.football.di

import android.app.Application
import android.content.Context
import coil.ImageLoader
import coil.imageLoader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesContext(application: Application): Context = application.applicationContext

    @Provides
    fun providesImageLoader(context: Context): ImageLoader = context.imageLoader


}