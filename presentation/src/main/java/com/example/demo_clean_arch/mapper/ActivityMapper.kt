package com.example.demo_clean_arch.mapper

import com.example.demo_clean_arch.model.ActivityModel
import com.example.domain.model.DemoDomainEntity
import javax.inject.Inject

class ActivityMapper @Inject constructor() : Mapper<DemoDomainEntity, ActivityModel> {

    override fun toModel(entity: DemoDomainEntity) = ActivityModel(
        id = entity.id,
        accessibility = entity.accessibility,
        activity = entity.activity,
        key = entity.key,
        type = entity.type,
        participants = entity.participants,
        link = entity.link,
        price = entity.price
    )
}
