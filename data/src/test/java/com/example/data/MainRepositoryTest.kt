package com.example.data

import com.example.data.datasource.local.datasource.MainLocalDataSource
import com.example.data.datasource.remote.datasource.MainRemoteDataSource
import com.example.data.mapper.MovieSummaryModelMapper
import com.example.data.repository.MainRepositoryImpl
import com.example.data.utils.createList
import com.example.data.utils.createListDomainModel
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
class MainRepositoryTest {

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
                MovieSummaryModelMapper(),
            )
            Mockito.`when`(remoteDataSource.getTrendingMovies("test_key"))
                .thenReturn(createResponseObject())
        }
    }

    @Test
    fun getTrendingMoviesTest() = runBlocking {
        val expect = createListDomainModel()
        val result = repository.getTrendings("test_key")
        Assert.assertEquals(expect, result)
    }
}
