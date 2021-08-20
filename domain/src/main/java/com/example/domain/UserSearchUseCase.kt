package com.example.domain

import com.example.data.Resource
import com.example.data.remote.api.ApiServices
import com.example.data.remote.model.UserSearchResponseModel
import com.example.domain.base.BaseUseCase
import javax.inject.Inject


class UserSearchUseCase @Inject constructor(private val apiServices: ApiServices) : BaseUseCase() {

    suspend fun userSearch(
        userName: String,
        onSuccess: (Resource<UserSearchResponseModel>) -> Unit,
        onError: (Resource<UserSearchResponseModel>) -> Unit
    ) {
        this.invoke(onError, onSuccess, { apiServices.searchUser(userName)})
    }

}