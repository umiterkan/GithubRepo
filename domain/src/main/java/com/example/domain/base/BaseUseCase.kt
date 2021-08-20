package com.example.domain.base

import com.example.data.Resource
import retrofit2.Response
import timber.log.Timber
import java.net.SocketTimeoutException
import java.net.UnknownHostException


open class BaseUseCase {

    protected suspend fun <T> invoke(
        onError: (Resource<T>) -> Unit,
        onSuccess: (Resource<T>) -> Unit,
        call: suspend () -> Response<T>
    ) {
        try {
            val response = call()
            Timber.d("Response Code : ${response.code()}")
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) onSuccess(Resource.success(body))
            } else if (response.code() == 404) {
                onError(error("User ${response.message()}"))
            } else {
                onError(error(" ${response.code()} ${response.message()}"))
            }
        } catch (e: SocketTimeoutException) {
            onError(error("TimeOut"))
        } catch (e: UnknownHostException) {
            onError(error("Connection Error"))
        } catch (e: Exception) {
            onError(error(e.message ?: e.toString()))
        }
    }



    private fun <T> error(message: String): Resource<T> {
        return Resource.error(message)
    }

}