package com.example.domain.base

import com.example.data.model.ErrorModel


interface UseCaseResponse<T> {

    fun onSuccess(result: T?)

    fun onError(errorModel: ErrorModel)
}