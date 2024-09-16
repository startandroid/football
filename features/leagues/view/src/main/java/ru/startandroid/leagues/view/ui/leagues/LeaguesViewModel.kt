package ru.startandroid.leagues.view.ui.leagues

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.startandroid.core.common.mapping.Mapper
import ru.startandroid.core.ui.components.uistate.UiStateData
import ru.startandroid.leagues.api.model.LeagueExt
import ru.startandroid.leagues.domain.model.League
import ru.startandroid.leagues.domain.usecase.GetCupsByCountryUseCase
import ru.startandroid.leagues.domain.usecase.GetLeaguesByCountryUseCase
import ru.startandroid.leagues.domain.usecase.invoke
import javax.inject.Inject

@HiltViewModel
class LeaguesViewModel @Inject constructor(
    private val getLeaguesUseCase: GetLeaguesByCountryUseCase,
    private val getCupsUseCase: GetCupsByCountryUseCase,
    private val leagueMapper: Mapper<League, LeagueExt>,
    savedStateHandle: SavedStateHandle
): ViewModel(), LeaguesHolder {

    enum class LeagueType {
        LEAGUES, CUPS
    }

    private val countryCode = checkNotNull(savedStateHandle.get<String>(LeaguesNavScreen.NAV_ARG_COUNTRY_CODE))

    private val _leagueType = MutableStateFlow(LeagueType.LEAGUES)
    val leagueType = _leagueType.asStateFlow()

    override val leagues = UiStateData {
        if (leagueType.value == LeagueType.LEAGUES) {
            getLeaguesUseCase(countryCode)
        } else {
            getCupsUseCase(countryCode)
        }
    }

    private val _selectedLeague = MutableStateFlow<LeagueExt?>(null)
    val selectedLeague = _selectedLeague.asStateFlow()

    fun onLeagueTypeChange(leagueType: LeagueType) {
        _leagueType.value = leagueType
        leagues.trigger()
    }

    override fun onLeagueClick(league: League) {
        _selectedLeague.value = leagueMapper.map(league)
    }
}