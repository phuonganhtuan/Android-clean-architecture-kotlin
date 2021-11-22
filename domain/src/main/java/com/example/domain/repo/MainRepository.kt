package com.example.domain.repo

import com.example.domain.model.MovieSummary

interface MainRepository {

    suspend fun getTrendings(key: String): List<MovieSummary>
}
