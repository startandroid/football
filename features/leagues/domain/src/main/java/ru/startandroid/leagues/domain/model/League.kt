package ru.startandroid.leagues.domain.model

data class League(
    val id: Int,
    val name: String,
    val logo: String,
    val seasons: List<Season>
) {
    data class Season(
        val year: Int
    )
}