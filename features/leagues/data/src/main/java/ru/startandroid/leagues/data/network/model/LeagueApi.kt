package ru.startandroid.leagues.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class LeagueApi(
    val league: League,
    val seasons: List<Season>
) {

    @Serializable
    data class League(
        val id: Int,
        val name: String,
        val logo: String
    )

    @Serializable
    data class Season(
        val year: Int
    )
}