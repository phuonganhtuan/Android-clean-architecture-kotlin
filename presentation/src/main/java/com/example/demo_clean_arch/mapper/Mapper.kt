package com.example.demo_clean_arch.mapper

interface Mapper<Entity : Any, PModel : Any> {
    fun toModel(entity: Entity): PModel
}
