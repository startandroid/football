package ru.startandroid.network.serialize

import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonTransformingSerializer

class ErrorsDeserializer: JsonTransformingSerializer<Map<String, String>>(
    MapSerializer(String.serializer(), String.serializer())
) {
    override fun transformDeserialize(element: JsonElement): JsonElement {
        if (element is JsonArray) return JsonObject(emptyMap())
        return element
    }
}