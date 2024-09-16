package ru.startandroid.teams.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class TeamApi(
    val team: Team,
    val venue: Venue
) {
    @Serializable
    data class Team(
        val id: Int,
        val name: String,
        val logo: String,
        val country: String
    )

    @Serializable
    data class Venue(
        val id: Int,
        val name: String,
        val city: String
    )
}