package ru.startandroid.countries.view.ui.countries

import androidx.compose.runtime.Composable
import ru.startandroid.core.navigation.NavScreen
import ru.startandroid.core.navigation.NavigationContext
import javax.inject.Inject

class CountriesNavScreen @Inject constructor() : NavScreen {

    override val route: String = ROUTE

    @Composable
    override fun Content(context: NavigationContext) {
        CountriesScreen(navController = context.navController)
    }

    companion object {
        const val ROUTE = "countries"
    }

}