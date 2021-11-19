package com.example.data.mapper

import com.example.data.model.DemoEntity
import com.example.domain.mapper.Mapper
import com.example.data.mapper.fromData.ActivityModelMapper
import com.example.domain.model.DemoDomainEntity
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ActivityModelMapperTest {

    private lateinit var dataEntity: DemoEntity
    private lateinit var domainModel: DemoDomainEntity
    private lateinit var mapper: Mapper<DemoEntity, DemoDomainEntity>

    @Before
    fun initTestData() {
        dataEntity = DemoEntity(
            id = 1,
            accessibility = 1.5,
            activity = "Test activity",
            link = "Test link",
            key = "TK",
            participants = 4,
            price = 0.0,
            type = "Outside"
        )
        domainModel = DemoDomainEntity(
            id = 1,
            accessibility = 1.5,
            activity = "Test activity",
            link = "Test link",
            key = "TK",
            participants = 4,
            price = 0.0,
            type = "Outside"
        )
        mapper = ActivityModelMapper()
    }

    @Test
    fun mapToDataModelTest() {
        val result = mapper.toModel(dataEntity)
        assertEquals(result, domainModel)
    }
}
