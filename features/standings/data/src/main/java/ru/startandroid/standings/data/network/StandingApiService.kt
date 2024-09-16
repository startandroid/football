package ru.startandroid.standings.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import ru.startandroid.core.common.model.DataResult
import ru.startandroid.standings.data.network.model.StandingResponse

interface StandingApiService {

    @GET("standings")
    suspend fun getStandings(
        @Query("league") league: Int,
        @Query("season") season: Int
    ): DataResult<StandingResponse>

}