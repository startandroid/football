package ru.startandroid.teams.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import ru.startandroid.core.common.model.DataResult
import ru.startandroid.teams.data.network.model.SeasonsResponse
import ru.startandroid.teams.data.network.model.TeamsResponse

interface TeamsApiService {

    @GET("teams")
    suspend fun getTeams(
        @Query("id") id: Int,
    ): DataResult<TeamsResponse>

    @GET("teams/seasons")
    suspend fun getSeasons(
        @Query("team") team: Int,
    ): DataResult<SeasonsResponse>

}