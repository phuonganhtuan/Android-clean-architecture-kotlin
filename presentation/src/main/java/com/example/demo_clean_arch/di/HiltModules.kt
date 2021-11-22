package com.example.demo_clean_arch.di

import com.example.demo_clean_arch.mapper.MovieSummaryMapper
import com.example.demo_clean_arch.model.MovieSummaryModel
import com.example.domain.mapper.Mapper
import com.example.domain.model.MovieSummary
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class LocalModules {

    @Binds
    abstract fun bindMovieModelMapper(
        mapper: MovieSummaryMapper
    ): Mapper<MovieSummary, MovieSummaryModel>
}
