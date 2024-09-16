package ru.startandroid.leagues.view.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet
import ru.startandroid.core.navigation.NavScreen
import ru.startandroid.leagues.api.navigation.LeaguesNavigation
import ru.startandroid.leagues.view.ui.leagues.LeaguesNavScreen
import ru.startandroid.leagues.view.navigation.LeaguesNavigationImpl
import ru.startandroid.leagues.view.ui.league.LeagueNavScreen

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class NavigationModule {

    @Binds
    @IntoSet
    abstract fun bindLeaguesNavScreen(leaguesNavScreen: LeaguesNavScreen): NavScreen

    @Binds
    @IntoSet
    abstract fun bindLeagueNavScreen(leagueNavScreen: LeagueNavScreen): NavScreen

    @Binds
    abstract fun bindLeaguesNavigation(leaguesNavigationImpl: LeaguesNavigationImpl): LeaguesNavigation
}