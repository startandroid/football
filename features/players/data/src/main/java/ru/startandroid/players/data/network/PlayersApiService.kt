package ru.startandroid.players.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import ru.startandroid.core.common.model.DataResult
import ru.startandroid.players.data.network.model.PlayersResponse

interface PlayersApiService {

    @GET("players")
    suspend fun getPlayers(
        @Query("team") teamId: Int,
        @Query("season") season: Int,
        @Query("page") page: Int
    ): DataResult<PlayersResponse>

}