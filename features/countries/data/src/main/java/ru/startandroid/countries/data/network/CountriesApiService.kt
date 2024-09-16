package ru.startandroid.countries.data.network

import retrofit2.http.GET
import ru.startandroid.core.common.model.DataResult
import ru.startandroid.countries.data.network.model.CountriesResponse


interface CountriesApiService {

    @GET("countries")
    suspend fun getCountries(): DataResult<CountriesResponse>


}