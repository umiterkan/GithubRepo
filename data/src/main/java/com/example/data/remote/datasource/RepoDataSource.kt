package com.example.data.remote.datasource

import com.example.data.remote.api.ApiServices
import javax.inject.Inject

/**
 * Created by umiterkan on 1/2/2021
 */

class RepoDataSource @Inject constructor(private val apiServices: ApiServices) : BaseDataSource() {

    suspend fun getRepoList(username: String) = getResult { apiServices.getRepoList(username) }
    suspend fun searchUser(username: String) = getResult { apiServices.searchUser(username) }

}