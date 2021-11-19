package com.example.data.repository

import com.example.data.datasource.local.datasource.MainLocalDataSource
import com.example.data.datasource.remote.datasource.MainRemoteDataSource
import com.example.data.model.DemoEntity
import com.example.domain.mapper.Mapper
import com.example.domain.model.DemoDomainEntity
import com.example.domain.repo.MainRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val localDataSource: MainLocalDataSource,
    private val remoteDataSource: MainRemoteDataSource,
    private val activityModelMapper: Mapper<DemoEntity, DemoDomainEntity>,
    private val activityEntityMapper: Mapper<DemoDomainEntity, DemoEntity>,
) : MainRepository {

    override fun getAllEntities() =
        localDataSource.getAllEntities().map {
            it.map { entity ->
                activityModelMapper.toModel(entity)
            }
        }

    override suspend fun addEntity(entity: DemoDomainEntity) =
        localDataSource.addEntity(activityEntityMapper.toModel(entity))

    override suspend fun deleteEntity(entity: DemoDomainEntity) =
        localDataSource.deleteEntity(activityEntityMapper.toModel(entity))

    override suspend fun getRandomActivity(): DemoDomainEntity {
        return activityModelMapper.toModel(remoteDataSource.getRandomActivity())
    }
}
