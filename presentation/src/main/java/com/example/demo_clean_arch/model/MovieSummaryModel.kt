package com.example.demo_clean_arch.model

data class MovieSummaryModel(
    override val id: Int?,
    val adult: Boolean?,
    val backdrop_path: String?,
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
) : PresentationModel() {

    val displayName: String get() = if (title.isNullOrEmpty()) name ?: "" else title
}
