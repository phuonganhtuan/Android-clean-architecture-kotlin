package com.example.data.remote

import com.example.data.datasource.remote.api.ApiService
import com.example.data.datasource.remote.impl.MainRemoteDataSourceImpl
import com.example.data.model.DemoEntity
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
class RemoteDataSourceTest {

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

    @Mock
    private lateinit var api: ApiService

    private lateinit var dataSource: MainRemoteDataSourceImpl

    @Before
    fun setupData() {
        runBlocking {
            MockitoAnnotations.initMocks(this)
            dataSource = MainRemoteDataSourceImpl(api)
            Mockito.`when`(api.getRandomActivity()).thenReturn(demoEntity)
        }
    }

    @Test
    fun getRandomActivityTest() = runBlocking {
        val result = dataSource.getRandomActivity()
        Assert.assertEquals(demoEntity, result)
    }
}
