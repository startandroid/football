package ru.startandroid.football.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet
import ru.startandroid.core.navigation.NavScreen
import ru.startandroid.football.ui.mainmenu.MainMenuNavScreen

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class NavigationModule {

    @IntoSet
    @Binds
    abstract fun bindsMainMenuNavScreen(mainScreen: MainMenuNavScreen): NavScreen
}