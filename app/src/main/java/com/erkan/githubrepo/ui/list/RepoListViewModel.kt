package com.erkan.githubrepo.ui.list

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Resource
import com.example.data.database.dao.FavoriteDao
import com.example.data.database.entity.Favorite
import com.example.data.model.Repo
import com.example.data.remote.repository.RepoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by umiterkan on 1/2/2021
 */

@HiltViewModel
class RepoListViewModel @Inject constructor(
    val provideRepository: RepoRepository,
    val favoriteDao: FavoriteDao
) : ViewModel() {

    var observeRepoList = MutableLiveData<List<Repo>>()
    var observeError = MutableLiveData<String>()
    var observeLoading = ObservableBoolean()

    fun processFavorite(repo: Repo) {
        if (repo.is_favorite) deleteFavorite(repo) else insertFavorite(repo)
    }

    private fun insertFavorite(repo: Repo) {
        if (!repo.id.isNullOrEmpty() && !repo.name.isNullOrEmpty()) {
            viewModelScope.launch {
                favoriteDao.insert(Favorite(repo.id!!.toInt(), repo.name!!))
            }
        }
    }

    private fun deleteFavorite(repo: Repo) {
        if (!repo.id.isNullOrEmpty()) {
            viewModelScope.launch {
                favoriteDao.delete(repo.id!!.toInt())
            }
        }
    }

    fun getRepoList(username: String) {
        observeLoading.set(true)
        viewModelScope.launch {
            val resultData = provideRepository.getRepoList(username)
            when (resultData.status) {
                Resource.Status.SUCCESS -> {
                    observeLoading.set(false)
                    observeRepoList.postValue(resultData.data)
                    observeError.postValue(String())
                }
                Resource.Status.ERROR -> {
                    observeLoading.set(false)
                    observeError.postValue(resultData.message)
                    observeRepoList.postValue(null)
                }
                Resource.Status.LOADING -> {
                }
            }
        }
    }


}