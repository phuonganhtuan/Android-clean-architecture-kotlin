package com.example.domain.model

data class DemoDomainEntity(
    var id: Int? = 0,
    val accessibility: Double?,
    val activity: String?,
    val key: String?,
    val link: String?,
    val participants: Int?,
    val price: Double?,
    val type: String?,
) : BaseDomainEntity()
