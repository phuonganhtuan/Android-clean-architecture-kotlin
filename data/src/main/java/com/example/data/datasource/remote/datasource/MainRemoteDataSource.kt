package com.example.data.datasource.remote.datasource

import com.example.data.base.BaseRemoteEntity
import com.example.data.model.MovieSummaryEntity

interface MainRemoteDataSource {

    suspend fun getTrendingMovies(key: String): BaseRemoteEntity<List<MovieSummaryEntity>>
}
