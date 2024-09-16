package ru.startandroid.players.domain.model

data class Player(
    val id: Int,
    val name: String,
    val age: String,
    val nationality: String,
    val height: String,
    val weight: String,
    val photo: String?
)