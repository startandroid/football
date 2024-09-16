package ru.startandroid.leagues.data.network.model

import kotlinx.serialization.Serializable
import ru.startandroid.network.model.NetworkResponse

@Serializable
class LeaguesResponse: NetworkResponse<LeagueApi>()