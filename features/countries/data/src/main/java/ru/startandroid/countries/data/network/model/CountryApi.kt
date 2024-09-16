package ru.startandroid.countries.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CountryApi(
    val name: String,
    val code: String?,
    val flag: String?
)