package ru.startandroid.players.view.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet
import ru.startandroid.core.navigation.NavScreen
import ru.startandroid.players.api.navigation.PlayersNavigation
import ru.startandroid.players.view.navigation.PlayersNavigationImpl
import ru.startandroid.players.view.ui.PlayersNavScreen

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class NavigationModule {

    @Binds
    @IntoSet
    abstract fun bindsPlayersNavScreen(playersNavScreen: PlayersNavScreen): NavScreen

    @Binds
    abstract fun bindsPlayersNavigation(playersNavigationImpl: PlayersNavigationImpl): PlayersNavigation

}