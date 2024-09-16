package ru.startandroid.football.ui.mainscreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.startandroid.core.navigation.NavScreen
import ru.startandroid.core.navigation.Navigator
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val navScreens: MutableSet<NavScreen>,
    val navigator: Navigator
): ViewModel() {

}