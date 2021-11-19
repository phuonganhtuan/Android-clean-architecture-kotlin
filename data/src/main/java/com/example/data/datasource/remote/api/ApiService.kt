package com.example.data.datasource.remote.api

import com.example.data.model.DemoEntity
import retrofit2.http.GET

interface ApiService {

    @GET("activity")
    suspend fun getRandomActivity(): DemoEntity
}
