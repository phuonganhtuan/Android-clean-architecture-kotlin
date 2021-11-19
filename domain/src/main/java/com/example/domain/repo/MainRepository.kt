package com.example.domain.repo

import com.example.domain.model.DemoDomainEntity
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getAllEntities(): Flow<List<DemoDomainEntity>>
    suspend fun addEntity(entity: DemoDomainEntity)
    suspend fun deleteEntity(entity: DemoDomainEntity)
    suspend fun getRandomActivity(): DemoDomainEntity
}
