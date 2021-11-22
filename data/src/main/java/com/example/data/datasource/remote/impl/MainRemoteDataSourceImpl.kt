package com.example.data.datasource.remote.impl

import com.example.data.datasource.remote.api.ApiService
import com.example.data.datasource.remote.datasource.MainRemoteDataSource
import javax.inject.Inject

class MainRemoteDataSourceImpl @Inject constructor(private val api: ApiService) :
    MainRemoteDataSource {

    override suspend fun getTrendingMovies(key: String) = api.getTrendingDay(key)
}
