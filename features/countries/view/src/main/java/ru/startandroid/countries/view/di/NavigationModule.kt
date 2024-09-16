package ru.startandroid.countries.view.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet
import ru.startandroid.countries.api.navigation.CountriesNavigation
import ru.startandroid.core.navigation.NavScreen
import ru.startandroid.countries.view.ui.countries.CountriesNavScreen
import ru.startandroid.countries.view.navigation.CountriesNavigationImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class NavigationModule {

    @Binds
    @IntoSet
    abstract fun bindCountriesNavScreen(countriesNavScreen: CountriesNavScreen): NavScreen

    @Binds
    abstract fun bindCountriesNavigation(countriesNavigationImpl: CountriesNavigationImpl): CountriesNavigation


}