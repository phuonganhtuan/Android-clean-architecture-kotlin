package com.example.demo_clean_arch.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo_clean_arch.model.MovieSummaryModel
import com.example.domain.mapper.Mapper
import com.example.domain.model.MovieSummary
import com.example.domain.usecase.GetTrendingMoviesUseCase
import com.example.shared.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTrendingMoviesUseCase: GetTrendingMoviesUseCase,
    private val movieSummaryMapper: Mapper<MovieSummary, MovieSummaryModel>,
) : ViewModel() {

    val isLoading: StateFlow<Boolean> get() = _isLoading
    private val _isLoading = MutableStateFlow(false)

    val errorMsd: StateFlow<String> get() = _errorMsg
    private val _errorMsg = MutableStateFlow("")

    val trendingMovieList: StateFlow<List<MovieSummaryModel>> get() = _trendingMovieList
    private val _trendingMovieList = MutableStateFlow(emptyList<MovieSummaryModel>())

    init {
        getTrendingMovies()
    }

    private fun getTrendingMovies() = viewModelScope.launch {
        _isLoading.value = true
        try {
            flowOf(getTrendingMoviesUseCase.invokeSuspend(GetTrendingMoviesUseCase.Params(Constants.apiKey))).collect {
                _trendingMovieList.value = it.map { movie ->
                    movieSummaryMapper.toModel(movie)
                }
            }
        } catch (exception: Exception) {
            _errorMsg.value = "Error fetching new activity."
            resetError()
        } finally {
            _isLoading.value = false
        }
    }

    private fun resetError() {
        _errorMsg.value = ""
    }
}
