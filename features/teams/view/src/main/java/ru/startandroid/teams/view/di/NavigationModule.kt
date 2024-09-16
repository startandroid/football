package ru.startandroid.teams.view.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import ru.startandroid.core.navigation.NavScreen
import ru.startandroid.teams.api.navigation.TeamsNavigation
import ru.startandroid.teams.view.navigation.TeamsNavigationImpl
import ru.startandroid.teams.view.ui.team.TeamNavScreen

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class NavigationModule {

    @Binds
    abstract fun bindsTeamsNavigation(teamsNavigationImpl: TeamsNavigationImpl): TeamsNavigation

    @Binds
    @IntoSet
    abstract fun bindsTeamNavScreen(teamNavScreen: TeamNavScreen): NavScreen

}