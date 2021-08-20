package com.example.data.remote.datasource


import com.example.data.Resource
import retrofit2.Response
import timber.log.Timber
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by umiterkan on 1/2/2021
 */

abstract class BaseDataSource {

    init {
        Timber.d("init BaseDataSource")
    }

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            Timber.d(response.toString())
            Timber.d(response.message())
            Timber.d("${response.code()}")
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.success(body)
            }else if (response.code()==404){
                return error("User ${response.message()}")
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: SocketTimeoutException) {
            return error("TimeOut")
        }catch (e:UnknownHostException){
            return error("Connection Error")
        }
        catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        return Resource.error(message)
    }

}