package com.example.data.mapper

import com.example.data.model.MovieSummaryEntity
import com.example.domain.mapper.Mapper
import com.example.domain.model.MovieSummary
import javax.inject.Inject

class MovieSummaryModelMapper @Inject constructor() : Mapper<MovieSummaryEntity, MovieSummary> {

    override fun toModel(entity: MovieSummaryEntity) = MovieSummary(
        adult = entity.adult,
        backdrop_path = entity.backdrop_path,
        id = entity.id,
        original_language = entity.original_language,
        original_title = entity.original_title,
        overview = entity.overview,
        popularity = entity.popularity,
        poster_path = entity.poster_path,
        release_date = entity.release_date,
        title = entity.title,
        video = entity.video,
        vote_average = entity.vote_average,
        vote_count = entity.vote_count,
        name = entity.name,
        media_type = entity.media_type,
    )
}
