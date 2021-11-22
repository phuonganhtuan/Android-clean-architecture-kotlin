package com.example.data.remote

import com.example.data.datasource.remote.api.ApiService
import com.example.data.datasource.remote.impl.MainRemoteDataSourceImpl
import com.example.data.utils.createResponseObject
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

    @Mock
    private lateinit var api: ApiService

    private lateinit var dataSource: MainRemoteDataSourceImpl

    @Before
    fun setupData() {
        runBlocking {
            MockitoAnnotations.initMocks(this)
            dataSource = MainRemoteDataSourceImpl(api)
            Mockito.`when`(api.getTrendingDay("key_test")).thenReturn(createResponseObject())
        }
    }

    @Test
    fun getTrendingMoviesTest() = runBlocking {
        val result = dataSource.getTrendingMovies("key_test")
        Assert.assertEquals(result, createResponseObject())
    }
}
