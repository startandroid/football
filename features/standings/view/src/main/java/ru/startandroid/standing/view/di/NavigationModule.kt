package ru.startandroid.standing.view.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet
import ru.startandroid.core.navigation.NavScreen
import ru.startandroid.standing.api.navigation.StandingsNavigation
import ru.startandroid.standing.view.navigation.StandingsNavigationImpl
import ru.startandroid.standing.view.ui.standings.StandingsNavScreen

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class NavigationModule {

    @Binds
    @IntoSet
    abstract fun bindsStandingsNavScreen(standingsNavScreen: StandingsNavScreen): NavScreen

    @Binds
    abstract fun bindsStandingsNavigation(standingsNavigationImpl: StandingsNavigationImpl): StandingsNavigation

}