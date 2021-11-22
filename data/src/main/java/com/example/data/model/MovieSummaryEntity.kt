package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieSummaryEntity(
    val adult: Boolean?,
    val backdrop_path: String?,
    @PrimaryKey(autoGenerate = true)
    override val id: Int? = 0,
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
) : BaseDataEntity()
