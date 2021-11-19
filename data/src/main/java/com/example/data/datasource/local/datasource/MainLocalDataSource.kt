package com.example.data.datasource.local.datasource

import com.example.data.model.DemoEntity
import kotlinx.coroutines.flow.Flow

interface MainLocalDataSource {

    fun getAllEntities(): Flow<List<DemoEntity>>

    suspend fun addEntity(entity: DemoEntity)

    suspend fun deleteEntity(entity: DemoEntity)
}
