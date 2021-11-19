package com.example.data.di

import android.content.Context
import com.example.data.datasource.local.database.AppDatabase
import com.example.data.datasource.local.datasource.MainLocalDataSource
import com.example.data.datasource.local.impl.MainLocalDataSourceImpl
import com.example.data.datasource.remote.datasource.MainRemoteDataSource
import com.example.data.datasource.remote.impl.MainRemoteDataSourceImpl
import com.example.data.repository.MainRepositoryImpl
import com.example.domain.repo.MainRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
abstract class LocalModules {

    @Binds
    abstract fun bindMainRepo(
        mainRepoImpl: MainRepositoryImpl
    ): MainRepository

    @Binds
    abstract fun bindMainLocalDataSource(
        mainLocalDataSource: MainLocalDataSourceImpl
    ): MainLocalDataSource

    @Binds
    abstract fun bindMainRemoteDataSource(
        mainRemoteDataSource: MainRemoteDataSourceImpl
    ): MainRemoteDataSource
}

@Module
@InstallIn(ViewModelComponent::class)
object DBModules {

    @Provides
    fun provideDemoDatabase(
        @ApplicationContext app: Context
    ) = AppDatabase.invoke(app)

    @Provides
    fun provideYourDao(db: AppDatabase) = db.demoDao()
}
