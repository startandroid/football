package ru.startandroid.core.common.model

class DataResult<T>(
    val data: T? = null,
    val error: ErrorType? = null,
    val nextPage: Int? = null
) {
    enum class ErrorType {
        NETWORK, AUTH, REQUEST, SERVER, UNKNOWN
    }

    fun <R> map(func: (T) -> R?): DataResult<R> {
        return DataResult(data = data?.let(func), error = error, nextPage = nextPage)
    }

    override fun toString(): String {
        return "DataResult(nextPage=$nextPage, error=$error, data=$data)"
    }

}
