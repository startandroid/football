package ru.startandroid.players.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class PlayerApi(
    val player: Player
) {
    @Serializable
    data class Player(
        val id: Int,
        val name: String?,
        val age: Int?,
        val nationality: String?,
        val height: String?,
        val weight: String?,
        val photo: String?
    )
}