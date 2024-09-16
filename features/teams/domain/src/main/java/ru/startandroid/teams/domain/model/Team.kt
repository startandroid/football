package ru.startandroid.teams.domain.model

data class Team(
    val id: Int,
    val name: String,
    val logo: String,
    val country: String,
    val venue: Venue
) {
    data class Venue(
        val id: Int,
        val name: String,
        val city: String
    )
}