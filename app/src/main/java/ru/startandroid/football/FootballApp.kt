package ru.startandroid.football

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FootballApp: Application(), ImageLoaderFactory {
    override fun newImageLoader(): ImageLoader {

        return ImageLoader.Builder(this)
            .crossfade(true)
            .build()
    }
}