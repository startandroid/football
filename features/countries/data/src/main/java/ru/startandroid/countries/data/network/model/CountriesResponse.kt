package ru.startandroid.countries.data.network.model

import kotlinx.serialization.Serializable
import ru.startandroid.network.model.NetworkResponse

@Serializable
class CountriesResponse: NetworkResponse<CountryApi>()