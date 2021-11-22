package com.example.data.di

import com.example.data.mapper.MovieSummaryModelMapper
import com.example.data.model.MovieSummaryEntity
import com.example.domain.mapper.Mapper
import com.example.domain.model.MovieSummary
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class HiltModules {

    @Binds
    abstract fun bindMovieMapper(
        entityMapper: MovieSummaryModelMapper
    ): Mapper<MovieSummaryEntity, MovieSummary>
}
