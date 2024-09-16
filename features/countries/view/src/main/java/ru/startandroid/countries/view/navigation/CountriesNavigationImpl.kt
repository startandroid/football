package ru.startandroid.countries.view.navigation

import ru.startandroid.countries.api.navigation.CountriesNavigation
import ru.startandroid.core.navigation.Navigator
import ru.startandroid.countries.view.ui.countries.CountriesNavScreen
import javax.inject.Inject


class CountriesNavigationImpl @Inject constructor(
    private val navigator: Navigator
) : CountriesNavigation {
    override fun chooseCountry() {
        navigator.navigateTo(CountriesNavScreen.ROUTE)
    }
}