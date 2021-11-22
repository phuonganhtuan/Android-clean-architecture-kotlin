package com.example.demo_clean_arch.screens

import com.example.demo_clean_arch.mapper.MovieSummaryMapper
import com.example.demo_clean_arch.screens.home.HomeViewModel
import com.example.demo_clean_arch.utils.createListDomainModel
import com.example.demo_clean_arch.utils.createListSummary
import com.example.domain.usecase.GetTrendingMoviesUseCase
import com.example.shared.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner


@ExperimentalCoroutinesApi
@RunWith(PowerMockRunner::class)
@PrepareForTest(
    GetTrendingMoviesUseCase::class,
)
class HomeViewModelTest {

    private lateinit var getTrendingMoviesUseCase: GetTrendingMoviesUseCase
    private val movieSummaryMapper = MovieSummaryMapper()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun initData() = runBlockingTest {
        Dispatchers.setMain(TestCoroutineDispatcher())
        getTrendingMoviesUseCase = Mockito.mock(GetTrendingMoviesUseCase::class.java)
        `when`(getTrendingMoviesUseCase.invokeSuspend(GetTrendingMoviesUseCase.Params(Constants.apiKey))).thenReturn(
            createListDomainModel()
        )
        viewModel = HomeViewModel(
            getTrendingMoviesUseCase,
            movieSummaryMapper,
        )
    }

    @Test
    fun getTrendingMovieSuccessTest() = runBlockingTest {

        val expected = createListSummary()

        assertEquals(viewModel.trendingMovieList.first(), expected)
        assertEquals(viewModel.isLoading.first(), false)
    }

    @Test
    fun getRandomActivityErrorTest() = runBlocking {

        `when`(getTrendingMoviesUseCase.invokeSuspend(GetTrendingMoviesUseCase.Params(Constants.apiKey))).thenReturn(
            null
        )

        viewModel.getTrendingMovies()
        assertEquals(viewModel.errorMsd.first(), "Error fetching new trending movies.")
        assertEquals(viewModel.isLoading.first(), false)
    }
}
