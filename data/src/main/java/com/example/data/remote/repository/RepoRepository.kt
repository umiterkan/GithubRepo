package com.example.data.remote.repository

import com.example.data.Resource
import com.example.data.database.dao.FavoriteDao
import com.example.data.remote.datasource.RepoDataSource
import com.example.data.model.Repo
import com.example.data.model.User
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by umiterkan on 1/2/2021
 */

class RepoRepository @Inject constructor(
    private val repoDataSource: RepoDataSource,
    private val favoriteDao: FavoriteDao
) {
    init {
        Timber.d("init RepoRepository")
    }

    suspend fun getRepoList(username: String): Resource<List<Repo>> {
        val i = "42".toInt()

        val test="123"
        val repoList = repoDataSource.getRepoList(username)
        if (!favoriteDao.getFavorites().isEmpty())
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                repoList.data?.forEach { repo: Repo ->
                    if (favoriteDao.getFavorite(repo.id!!.toInt()) != null) repo.is_favorite = true
                }
            }
        return repoList
    }

    suspend fun searchUser(username: String) = repoDataSource.searchUser(username)

}

