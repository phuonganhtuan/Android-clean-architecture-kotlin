package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.base.BaseEntity

@Entity
data class DemoEntity(

    @PrimaryKey(autoGenerate = true)
    override var id: Int? = 0,
    val accessibility: Double?,
    val activity: String?,
    val key: String?,
    val link: String?,
    val participants: Int?,
    val price: Double?,
    val type: String?,
) : BaseEntity()
