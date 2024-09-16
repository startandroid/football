package ru.startandroid.network.adapter

import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.JsonEncoder
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.startandroid.core.common.model.DataResult
import ru.startandroid.network.model.NetworkResponse
import java.util.logging.Logger

class ResultCall<T : Any>(
    private val proxy: Call<T>
) : Call<DataResult<T>> {
    override fun enqueue(callback: Callback<DataResult<T>>) {
        proxy.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body()
                if (!response.isSuccessful || body == null) {
                    val errorType = when (response.code()) {
                        401 -> DataResult.ErrorType.AUTH
                        in 400..499 -> DataResult.ErrorType.SERVER
                        in 500..599 -> DataResult.ErrorType.SERVER
                        else -> DataResult.ErrorType.UNKNOWN
                    }
                    Logger.getLogger(ResultCall::class.java.name).warning("http code: ${response.code()}")
                    callback.onResponse(this@ResultCall, Response.success(
                        DataResult(error = errorType)
                    ))
                } else {
                    val error = (body as? NetworkResponse<*>)?.errors?.values.orEmpty().firstOrNull()
                    if (error != null) {
                        Logger.getLogger(ResultCall::class.java.name).warning("error: $error")
                        callback.onResponse(this@ResultCall, Response.success(
                            DataResult(error = DataResult.ErrorType.REQUEST)
                        ))
                    } else {
                        val nextPage = (body as? NetworkResponse<*>)?.paging?.run {
                            if (total > current) current + 1 else null
                        }
                        callback.onResponse(this@ResultCall, Response.success(
                            DataResult(data = body, nextPage = nextPage)
                        ))
                    }
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                val errorType = when (t) {
                    is java.net.UnknownHostException,
                    is java.net.ConnectException,
                    is java.net.SocketTimeoutException -> DataResult.ErrorType.NETWORK
                    is SerializationException -> DataResult.ErrorType.REQUEST
                    else -> DataResult.ErrorType.UNKNOWN
                }
                Logger.getLogger(ResultCall::class.java.name).warning(t.message)
                callback.onResponse(this@ResultCall, Response.success(
                    DataResult(error = errorType)
                ))
            }
        })
    }

    override fun clone(): Call<DataResult<T>> = ResultCall(proxy.clone())
    override fun execute(): Response<DataResult<T>> = throw UnsupportedOperationException("ResultCall does not support execute")
    override fun isExecuted(): Boolean = proxy.isExecuted
    override fun cancel() = proxy.cancel()
    override fun isCanceled(): Boolean = proxy.isCanceled
    override fun request(): Request = proxy.request()
    override fun timeout(): Timeout = proxy.timeout()
}