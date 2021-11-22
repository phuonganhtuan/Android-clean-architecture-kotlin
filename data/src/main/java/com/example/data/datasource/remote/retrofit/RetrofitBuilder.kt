package com.example.data.datasource.remote.retrofit

import com.example.data.datasource.remote.api.ApiService
import com.example.shared.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)

    private fun getRetrofit() =
        Retrofit.Builder()
            .baseUrl(Constants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}
