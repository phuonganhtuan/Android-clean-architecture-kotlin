package com.example.demo_clean_arch.di

import com.example.demo_clean_arch.mapper.ActivityDomainMapper
import com.example.demo_clean_arch.mapper.ActivityMapper
import com.example.demo_clean_arch.mapper.Mapper
import com.example.demo_clean_arch.model.ActivityModel
import com.example.domain.model.DemoDomainEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class LocalModules {

    @Binds
    abstract fun bindActivityMapper(
        mapper: ActivityMapper
    ): Mapper<DemoDomainEntity, ActivityModel>

    @Binds
    abstract fun bindActivityDomainMapper(
        mapper: ActivityDomainMapper
    ): Mapper<ActivityModel, DemoDomainEntity>
}
