package ru.startandroid.standing.view.ui.standings

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.startandroid.core.ui.components.uistate.UiStateData
import ru.startandroid.countries.api.model.CountryExt
import ru.startandroid.countries.api.navigation.CountriesNavigation
import ru.startandroid.leagues.api.model.LeagueExt
import ru.startandroid.leagues.api.navigation.LeaguesNavigation
import ru.startandroid.standings.domain.usecase.GetStandingsUseCase
import ru.startandroid.standings.domain.usecase.invoke
import ru.startandroid.teams.api.navigation.TeamsNavigation
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val countriesNavigation: CountriesNavigation,
    private val leaguesNavigation: LeaguesNavigation,
    private val getStandingsUseCase: GetStandingsUseCase,
    private val teamsNavigation: TeamsNavigation,
) : ViewModel(), StandingsHolder {

//    private val defaultCountry = CountryExt(name="England", code="GB", flag="https://media.api-sports.io/flags/gb.svg")
    private val _country = MutableStateFlow<CountryExt?>(null)
    val country = _country.asStateFlow()

//    private val defaultLeague = LeagueExt(name="Premier League", id=39)
    private val _league = MutableStateFlow<LeagueExt?>(null)
    val league = _league.asStateFlow()

//    private val defaultSeason = 2023
    private val _season = MutableStateFlow<Int?>(null)
    val season = _season.asStateFlow()

    override val standings = UiStateData() {
        val leagueId = _league.value?.id ?: return@UiStateData null
        val season = _season.value ?: return@UiStateData null
        getStandingsUseCase(league = leagueId, season = season)
    }

    fun onCountryClick() {
        countriesNavigation.chooseCountry()
    }

    fun onCountryChosen(country: CountryExt) {
        _country.value = country
        _league.value = null
        _season.value = null
    }

    fun onLeagueClick() {
        val countryCode = _country.value?.code ?: return
        leaguesNavigation.chooseLeague(countryCode)
    }

    fun onLeagueChosen(league: LeagueExt) {
        _league.value = league
        _season.value = null
    }

    fun onSeasonClick() {
        val leagueId = _league.value?.id ?: return
        leaguesNavigation.chooseSeason(leagueId.toString())
    }

    fun onSeasonChosen(season: Int) {
        _season.value = season
        standings.trigger()
    }

    override fun onTeamClick(teamId: Int) {
        teamsNavigation.openTeam(teamId.toString())
    }

}