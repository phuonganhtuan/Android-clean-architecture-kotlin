package com.example.data.datasource.local.impl

import com.example.data.datasource.local.dao.DemoDao
import com.example.data.datasource.local.datasource.MainLocalDataSource
import com.example.data.model.DemoEntity
import javax.inject.Inject

class MainLocalDataSourceImpl @Inject constructor(private val dao: DemoDao) : MainLocalDataSource {

    override fun getAllEntities() = dao.getAllEntities()

    override suspend fun addEntity(entity: DemoEntity) = dao.addEntity(entity)

    override suspend fun deleteEntity(entity: DemoEntity) = dao.deleteEntity(entity)
}
