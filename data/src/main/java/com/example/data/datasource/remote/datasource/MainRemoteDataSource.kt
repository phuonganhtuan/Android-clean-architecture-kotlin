package com.example.data.datasource.remote.datasource

import com.example.data.model.DemoEntity

interface MainRemoteDataSource {

    suspend fun getRandomActivity(): DemoEntity
}
