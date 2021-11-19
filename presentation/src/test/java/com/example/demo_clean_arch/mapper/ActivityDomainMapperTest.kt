package com.example.demo_clean_arch.mapper

import com.example.demo_clean_arch.model.ActivityModel
import com.example.domain.model.DemoDomainEntity
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ActivityDomainMapperTest {

    private lateinit var activityModel: ActivityModel
    private lateinit var domainModel: DemoDomainEntity
    private lateinit var mapper: com.example.demo_clean_arch.mapper.Mapper<ActivityModel, DemoDomainEntity>

    @Before
    fun initTestData() {
        activityModel = ActivityModel(
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
        mapper = ActivityDomainMapper()
    }

    @Test
    fun mapToDataModelTest() {
        val result = mapper.toModel(activityModel)
        Assert.assertEquals(result, domainModel)
    }
}