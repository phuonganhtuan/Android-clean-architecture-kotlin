package com.example.data.mapper

import com.example.data.model.MovieSummaryEntity
import com.example.data.utils.dataEntity
import com.example.data.utils.domainModel
import com.example.domain.mapper.Mapper
import com.example.domain.model.MovieSummary
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MovieSummaryMapperTest {

    private lateinit var entity: MovieSummaryEntity
    private lateinit var model: MovieSummary
    private lateinit var mapper: Mapper<MovieSummaryEntity, MovieSummary>

    @Before
    fun initTestData() {
        entity = dataEntity
        model = domainModel
        mapper = MovieSummaryModelMapper()
    }

    @Test
    fun mapToDataModelTest() {
        val result = mapper.toModel(dataEntity)
        assertEquals(result, domainModel)
    }
}
