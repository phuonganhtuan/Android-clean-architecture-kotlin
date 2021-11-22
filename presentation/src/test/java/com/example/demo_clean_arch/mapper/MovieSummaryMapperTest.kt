package com.example.demo_clean_arch.mapper

import com.example.demo_clean_arch.model.MovieSummaryModel
import com.example.demo_clean_arch.utils.movieSummary
import com.example.demo_clean_arch.utils.movieSummaryDomain
import com.example.domain.mapper.Mapper
import com.example.domain.model.MovieSummary
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MovieSummaryMapperTest {

    private lateinit var domainModel: MovieSummary
    private lateinit var model: MovieSummaryModel
    private lateinit var mapper: Mapper<MovieSummary, MovieSummaryModel>

    @Before
    fun initTestData() {
        domainModel = movieSummaryDomain
        model = movieSummary
        mapper = MovieSummaryMapper()
    }

    @Test
    fun mapToDataModelTest() {
        val result = mapper.toModel(domainModel)
        assertEquals(result, model)
    }
}
