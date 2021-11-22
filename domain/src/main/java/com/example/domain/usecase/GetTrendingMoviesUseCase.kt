package com.example.domain.usecase

import com.example.domain.model.MovieSummary
import com.example.domain.repo.MainRepository
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(
    private val mainRepository: MainRepository,
) : UseCase<GetTrendingMoviesUseCase.Params, List<MovieSummary>>() {

    override fun invoke(params: Params): List<MovieSummary> {
        return emptyList()
    }

    override suspend fun invokeSuspend(params: Params): List<MovieSummary> {
        return mainRepository.getTrendings(key = params.key)
    }

    data class Params(var key: String)
}
