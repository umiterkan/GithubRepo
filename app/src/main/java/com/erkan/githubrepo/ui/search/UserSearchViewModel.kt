package com.erkan.githubrepo.ui.search

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.UserSearchUseCase
import com.erkan.githubrepo.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class UserSearchViewModel @Inject constructor(
    private val userSearchUseCase: UserSearchUseCase,
    application: Application
) : BaseViewModel(application) {

    val observableSearchText = MutableLiveData<String>()

    fun searchClick() {
        viewModelScope.launch {
            val userName = observableSearchText.value ?: ""

            userSearchUseCase.userSearch(userName, {
                Timber.d("" + it.data?.items.toString())
            }, {
                Timber.d("" + it.message)
            },)
        }
    }


}