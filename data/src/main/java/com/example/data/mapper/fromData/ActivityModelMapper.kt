package com.example.data.mapper.fromData

import com.example.data.model.DemoEntity
import com.example.domain.mapper.Mapper
import com.example.domain.model.DemoDomainEntity
import javax.inject.Inject

class ActivityModelMapper @Inject constructor() : Mapper<DemoEntity, DemoDomainEntity> {

    override fun toModel(entity: DemoEntity) = DemoDomainEntity(
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
