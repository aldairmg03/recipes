package com.amg.recipes.base

import retrofit2.Response
import com.amg.recipes.data.remote.Result

abstract class BaseDataSource {

    protected suspend fun <T> getResponse(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.Success(body)
            }
            return Result.Error(Exception("An unexpected error has occurred"))
        } catch (e: Exception) {
            return Result.Error(Exception("An unexpected error has occurred"))
        }
    }
}