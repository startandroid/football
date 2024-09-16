package ru.startandroid.players.data.network.model

import kotlinx.serialization.Serializable
import ru.startandroid.network.model.NetworkResponse

@Serializable
class PlayersResponse: NetworkResponse<PlayerApi>()