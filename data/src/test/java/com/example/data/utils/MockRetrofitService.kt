package com.example.data.utils

import com.example.data.datasource.remote.api.ApiService
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MockRetrofitService {

    val mockWebServer = MockWebServer()

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)

    private fun getRetrofit() =
        Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}
