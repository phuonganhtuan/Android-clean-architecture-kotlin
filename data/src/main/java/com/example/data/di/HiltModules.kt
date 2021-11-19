package com.example.data.di

import com.example.data.model.DemoEntity
import com.example.data.mapper.toData.ActivityEntityMapper
import com.example.data.mapper.fromData.ActivityModelMapper
import com.example.domain.mapper.Mapper
import com.example.domain.model.DemoDomainEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class HiltModules {

    @Binds
    abstract fun bindModelMapper(
        modelMapper: ActivityModelMapper
    ): Mapper<DemoEntity, DemoDomainEntity>

    @Binds
    abstract fun bindEntityMapper(
        entityMapper: ActivityEntityMapper
    ): Mapper<DemoDomainEntity, DemoEntity>
}
