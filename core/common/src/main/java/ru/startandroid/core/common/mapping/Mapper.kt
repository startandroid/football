package ru.startandroid.core.common.mapping

interface Mapper<In, Out> {
    fun map(from: In): Out
}