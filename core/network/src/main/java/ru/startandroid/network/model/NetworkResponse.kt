package ru.startandroid.network.model

import kotlinx.serialization.Serializable
import ru.startandroid.network.serialize.ErrorsDeserializer

@Serializable
open class NetworkResponse<R> {
    val response: List<R> = emptyList()
    @Serializable(with = ErrorsDeserializer::class)
    val errors: Map<String, String> = emptyMap()
    val paging: Paging? = null

    override fun toString(): String {
        return "NetworkResponse(response=$response, errors=$errors, paging=$paging)"
    }

    @Serializable
    data class Paging(
        val current: Int,
        val total: Int
    )
}