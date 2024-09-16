package ru.startandroid.leagues.data.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.startandroid.core.common.model.DataResult
import ru.startandroid.leagues.data.network.model.LeaguesResponse


interface LeaguesApiService {

    @GET("leagues?current=true")
    suspend fun getLeaguesByCountry(
        @Query("type") type: String,
        @Query("code") countryCode: String,
    ): DataResult<LeaguesResponse>

    @GET("leagues?current=true&country=world")
    suspend fun getWorldLeagues(
        @Query("type") type: String,
    ): DataResult<LeaguesResponse>

    @GET("leagues")
    suspend fun getLeagueById(
        @Query("id") id: Int
    ): DataResult<LeaguesResponse>

}