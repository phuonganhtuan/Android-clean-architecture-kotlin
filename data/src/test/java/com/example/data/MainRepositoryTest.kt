package com.example.data

import com.example.data.datasource.local.datasource.MainLocalDataSource
import com.example.data.datasource.remote.datasource.MainRemoteDataSource
import com.example.data.mapper.fromData.ActivityModelMapper
import com.example.data.mapper.toData.ActivityEntityMapper
import com.example.data.model.DemoEntity
import com.example.data.repository.MainRepositoryImpl
import com.example.data.utils.createList
import com.example.domain.model.DemoDomainEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
class MainRepositoryTest {

    val demoEntity = DemoEntity(
        id = 5,
        accessibility = 1.8,
        activity = "Test activity",
        link = "Test link",
        key = "TK",
        participants = 7,
        price = 0.4,
        type = "Outside"
    )

    val demoDomainEntity = DemoDomainEntity(
        id = 5,
        accessibility = 1.8,
        activity = "Test activity",
        link = "Test link",
        key = "TK",
        participants = 7,
        price = 0.4,
        type = "Outside"
    )


    @Mock
    private lateinit var localDataSource: MainLocalDataSource

    @Mock
    private lateinit var remoteDataSource: MainRemoteDataSource

    private lateinit var repository: MainRepositoryImpl

    @Before
    fun setupData() {
        runBlocking {
            MockitoAnnotations.initMocks(this)
            repository = MainRepositoryImpl(
                localDataSource,
                remoteDataSource,
                ActivityModelMapper(),
                ActivityEntityMapper()
            )
            Mockito.`when`(localDataSource.getAllEntities()).thenReturn(flowOf(createList()))
            Mockito.`when`(remoteDataSource.getRandomActivity()).thenReturn(demoEntity)
            Mockito.`when`(localDataSource.addEntity(demoEntity)).thenReturn(Unit)
        }
    }

    @Test
    fun getRandomActivityTest() = runBlocking {
        val result = repository.getRandomActivity()
        Assert.assertEquals(demoEntity, result)
    }

    @Test
    fun getLocalActivitiesTest() = runBlocking {
        val results = repository.getAllEntities()
        Assert.assertEquals(createList(), results.first())
    }

    @Test
    fun saveActivitiesTest() = runBlocking {
        Assert.assertNotNull(repository.addEntity(demoDomainEntity))
    }
}
