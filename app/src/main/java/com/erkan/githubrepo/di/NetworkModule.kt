package com.erkan.githubrepo.di

import com.erkan.githubrepo.BuildConfig
import com.example.data.remote.api.ApiServices
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by umiterkan on 1/2/2021
 */


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val SERVICE_BASE_URL = BuildConfig.SERVICE_BASE_URL

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(SERVICE_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideService(retrofit: Retrofit): ApiServices = retrofit.create(
        ApiServices::class.java)


}