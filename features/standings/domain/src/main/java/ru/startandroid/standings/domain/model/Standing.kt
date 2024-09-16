package ru.startandroid.standings.domain.model

data class Standing(
    val rank: Int,
    val team: Team,
    val points: Int,
    val goalsDiff: Int,
    val stats: Stats
) {
    data class Team(
        val id: Int,
        val name: String,
        val logo: String
    )

    data class Stats(
        val played: Int,
        val win: Int,
        val draw: Int,
        val lose: Int,
        val goals: Goals
    ) {
        data class Goals(
            val forx: Int,
            val against: Int
        )
    }
}