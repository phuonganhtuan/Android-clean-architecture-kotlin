package com.example.data.repository

import com.example.data.datasource.local.datasource.MainLocalDataSource
import com.example.data.datasource.remote.datasource.MainRemoteDataSource
import com.example.data.model.MovieSummaryEntity
import com.example.domain.mapper.Mapper
import com.example.domain.model.MovieSummary
import com.example.domain.repo.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val localDataSource: MainLocalDataSource,
    private val remoteDataSource: MainRemoteDataSource,
    private val movieSummaryModelMapper: Mapper<MovieSummaryEntity, MovieSummary>,
) : MainRepository {

    override suspend fun getTrendings(key: String) =
        remoteDataSource.getTrendingMovies(key).results?.map {
            movieSummaryModelMapper.toModel(it)
        } ?: emptyList()
}
