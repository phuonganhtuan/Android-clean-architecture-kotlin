package com.example.domain.mapper

interface Mapper<Entity, DModel> {
    fun toModel(entity: Entity): DModel
}
