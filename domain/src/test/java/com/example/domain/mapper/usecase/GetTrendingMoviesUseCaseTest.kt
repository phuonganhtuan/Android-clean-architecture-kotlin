package com.example.domain.mapper.usecase

import com.example.domain.mapper.usecase.utils.createListDomainModel
import com.example.domain.repo.MainRepository
import com.example.domain.usecase.GetTrendingMoviesUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetTrendingMoviesUseCaseTest {

    @Mock
    private lateinit var repository: MainRepository

    private lateinit var getTrendingMoviesUseCase: GetTrendingMoviesUseCase

    private val trendingMovieList = createListDomainModel()

    @Before
    fun setupData() {
        MockitoAnnotations.initMocks(this)
        getTrendingMoviesUseCase = GetTrendingMoviesUseCase(repository)
    }

    @Test
    fun getTrendingMoviesTest() = runBlocking {
        Mockito.`when`(repository.getTrendings("key_test")).thenReturn(createListDomainModel())
        val result = getTrendingMoviesUseCase.invokeSuspend(GetTrendingMoviesUseCase.Params("key_test"))
        Assert.assertEquals(trendingMovieList, result)
    }
}
