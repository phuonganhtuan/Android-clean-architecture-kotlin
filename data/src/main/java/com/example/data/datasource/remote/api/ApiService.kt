package com.example.data.datasource.remote.api

import com.example.data.base.BaseRemoteEntity
import com.example.data.model.MovieSummaryEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("trending/all/day")
    suspend fun getTrendingDay(
        @Query("api_key") apiKey: String
    ): BaseRemoteEntity<List<MovieSummaryEntity>>
}
