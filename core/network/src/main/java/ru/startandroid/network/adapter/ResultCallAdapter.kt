package ru.startandroid.network.adapter

import retrofit2.Call
import retrofit2.CallAdapter
import ru.startandroid.core.common.model.DataResult
import java.lang.reflect.Type

class ResultCallAdapter(
    private val resultType: Type
): CallAdapter<Type, Call<DataResult<Type>>> {

    override fun responseType(): Type {
        return resultType
    }

    override fun adapt(call: Call<Type>): Call<DataResult<Type>> {
        return ResultCall(call)
    }

}