package com.example.demo_clean_arch.model

import com.example.demo_clean_arch.utils.movieSummary
import com.example.demo_clean_arch.utils.movieSummaryNoTitle
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MovieSummaryModelTest {

    private lateinit var movieModel: MovieSummaryModel
    private lateinit var movieNoTitleModel: MovieSummaryModel

    @Before
    fun initTestData() {
        movieModel = movieSummary
        movieNoTitleModel = movieSummaryNoTitle
    }

    @Test
    fun displayNameWithTitleTest() {
        val result = movieModel.displayName
        Assert.assertEquals(result, "Test movie title")
    }

    @Test
    fun displayNameWithEmptyTitleTest() {
        val result = movieNoTitleModel.displayName
        Assert.assertEquals(result, "Test movie name")
    }
}
