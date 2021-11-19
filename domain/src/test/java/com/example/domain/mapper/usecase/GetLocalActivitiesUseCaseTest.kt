package com.example.domain.mapper.usecase

import com.example.data.model.DemoEntity
import com.example.data.repository.MainRepository
import com.example.data.mapper.fromData.ActivityModelMapper
import com.example.domain.model.DemoDomainEntity
import com.example.domain.usecase.GetLocalActivitiesUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetLocalActivitiesUseCaseTest {

    @Mock
    private lateinit var repository: MainRepository

    private val activityModelMapper = ActivityModelMapper()

    private lateinit var getLocalActivitiesUseCase: GetLocalActivitiesUseCase

    @Before
    fun setupData() {
        MockitoAnnotations.initMocks(this)
        getLocalActivitiesUseCase = GetLocalActivitiesUseCase(repository, activityModelMapper)
    }

    @Test
    fun getActivitiesTest() = runBlocking {
        Mockito.`when`(repository.getAllEntities()).thenReturn(flowOf(createDataList()))
        val result = getLocalActivitiesUseCase.invoke(GetLocalActivitiesUseCase.Params())
        Assert.assertEquals(createList(), result.first())
    }

    private fun createList(): List<DemoDomainEntity> {
        val item1 = DemoDomainEntity(
            id = 1,
            accessibility = 1.2,
            activity = "Test activity 1",
            link = "Test link 1",
            key = "TK1",
            participants = 4,
            price = 0.1,
            type = "Outside"
        )
        val item2 = DemoDomainEntity(
            id = 2,
            accessibility = 1.5,
            activity = "Test activity 2",
            link = "Test link 2",
            key = "TK2",
            participants = 8,
            price = 0.0,
            type = "Inside"
        )
        val item3 = DemoDomainEntity(
            id = 3,
            accessibility = 2.5,
            activity = "Test activity 3",
            link = "Test link 3",
            key = "TK3",
            participants = 1,
            price = 4.2,
            type = "Outside"
        )
        return listOf(item1, item2, item3)
    }

    private fun createDataList(): List<DemoEntity> {
        val item1 = DemoEntity(
            id = 1,
            accessibility = 1.2,
            activity = "Test activity 1",
            link = "Test link 1",
            key = "TK1",
            participants = 4,
            price = 0.1,
            type = "Outside"
        )
        val item2 = DemoEntity(
            id = 2,
            accessibility = 1.5,
            activity = "Test activity 2",
            link = "Test link 2",
            key = "TK2",
            participants = 8,
            price = 0.0,
            type = "Inside"
        )
        val item3 = DemoEntity(
            id = 3,
            accessibility = 2.5,
            activity = "Test activity 3",
            link = "Test link 3",
            key = "TK3",
            participants = 1,
            price = 4.2,
            type = "Outside"
        )
        return listOf(item1, item2, item3)
    }
}
