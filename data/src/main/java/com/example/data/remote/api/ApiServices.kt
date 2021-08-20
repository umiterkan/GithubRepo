package com.example.data.remote.api

import com.example.data.model.Repo
import com.example.data.remote.model.UserSearchResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by umiterkan on 1/2/2021
 */
interface ApiServices {

    @GET("users/{username}/repos")
    suspend fun getRepoList(@Path("username") username: String): Response<List<Repo>>


    @GET("search/users")
    suspend fun searchUser(@Query("q") username: String): Response<UserSearchResponseModel>

}