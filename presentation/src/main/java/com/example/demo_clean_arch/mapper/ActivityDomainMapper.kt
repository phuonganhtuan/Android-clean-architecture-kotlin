package com.example.demo_clean_arch.mapper

import com.example.demo_clean_arch.model.ActivityModel
import com.example.domain.model.DemoDomainEntity
import javax.inject.Inject

class ActivityDomainMapper @Inject constructor() : Mapper<ActivityModel, DemoDomainEntity> {

    override fun toModel(entity: ActivityModel) = DemoDomainEntity(
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
