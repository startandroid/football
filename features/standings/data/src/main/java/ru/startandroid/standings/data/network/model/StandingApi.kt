package ru.startandroid.standings.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StandingApi(
    val rank: Int,
    val team: Team,
    val points: Int,
    val goalsDiff: Int,
    val all: Stats
) {
    @Serializable
    data class Team(
        val id: Int,
        val name: String,
        val logo: String
    )
    @Serializable
    data class Stats(
        val played: Int,
        val win: Int,
        val draw: Int,
        val lose: Int,
        val goals: Goals
    ) {
        @Serializable
        data class Goals(
            @SerialName("for")
            val forx: Int,
            val against: Int
        )
    }
}