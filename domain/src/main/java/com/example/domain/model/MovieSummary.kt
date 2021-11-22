package com.example.domain.model

data class MovieSummary(
    val adult: Boolean?,
    val backdrop_path: String?,
    override val id: Int?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double? = 0.0,
    val vote_count: Int?,
    val name: String?,
    val media_type: String?,
) : BaseEntity()
