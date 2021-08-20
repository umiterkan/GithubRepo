package com.erkan.githubrepo.di

import com.example.data.database.dao.FavoriteDao
import com.example.data.remote.datasource.RepoDataSource
import com.example.data.remote.repository.RepoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

/**
 * Created by umiterkan on 1/6/2021
 */


@InstallIn(ActivityRetainedComponent::class)
@Module
object RepositoryModule {

    @ActivityRetainedScoped
    @Provides
    fun provideRepoRepository(
        repoDataSource: RepoDataSource,
        favoriteDao: FavoriteDao
    ): RepoRepository {
        return RepoRepository(repoDataSource, favoriteDao)
    }
}