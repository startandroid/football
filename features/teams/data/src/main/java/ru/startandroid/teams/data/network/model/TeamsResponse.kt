package ru.startandroid.teams.data.network.model

import kotlinx.serialization.Serializable
import ru.startandroid.network.model.NetworkResponse

@Serializable
class TeamsResponse: NetworkResponse<TeamApi>()