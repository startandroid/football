package ru.startandroid.standings.data.network.model

import kotlinx.serialization.Serializable
import ru.startandroid.network.model.NetworkResponse

@Serializable
class StandingResponse: NetworkResponse<StandingResponse.Item>() {
    @Serializable
    data class Item(
        val league: League
    ) {
        @Serializable
        data class League(
            val standings: List<List<StandingApi>>
        )
    }
}