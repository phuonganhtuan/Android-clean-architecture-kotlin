package com.example.data.mapper.toData

import com.example.data.model.DemoEntity
import com.example.domain.mapper.Mapper
import com.example.domain.model.DemoDomainEntity
import javax.inject.Inject

class ActivityEntityMapper @Inject constructor() : Mapper<DemoDomainEntity, DemoEntity> {

    override fun toModel(entity: DemoDomainEntity) = DemoEntity(
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
