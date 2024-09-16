package ru.startandroid.leagues.api.navigation

interface LeaguesNavigation {
    fun chooseLeague(countryCode: String)
    fun chooseSeason(leagueId: String)
}