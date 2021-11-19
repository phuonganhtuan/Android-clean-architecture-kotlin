package com.example.demo_clean_arch.screens

import com.example.demo_clean_arch.mapper.ActivityDomainMapper
import com.example.demo_clean_arch.mapper.ActivityMapper
import com.example.demo_clean_arch.screens.home.HomeViewModel
import com.example.domain.model.DemoDomainEntity
import com.example.domain.usecase.GetActivityUseCase
import com.example.domain.usecase.GetLocalActivitiesUseCase
import com.example.domain.usecase.SaveActivityUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner


@ExperimentalCoroutinesApi
@RunWith(PowerMockRunner::class)
@PrepareForTest(
    GetActivityUseCase::class,
    SaveActivityUseCase::class,
    GetLocalActivitiesUseCase::class
)
class HomeViewModelTest {

    private lateinit var getActivityUseCase: GetActivityUseCase

    private lateinit var saveActivityUseCase: SaveActivityUseCase

    private lateinit var getLocalActivitiesUseCase: GetLocalActivitiesUseCase

    private val activityMapper = ActivityMapper()
    private val activityDomainMapper = ActivityDomainMapper()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun initData() = runBlockingTest {
        Dispatchers.setMain(TestCoroutineDispatcher())
        getActivityUseCase = Mockito.mock(GetActivityUseCase::class.java)
        saveActivityUseCase = Mockito.mock(SaveActivityUseCase::class.java)
        getLocalActivitiesUseCase = Mockito.mock(GetLocalActivitiesUseCase::class.java)

        val expected = createList()
        `when`(getLocalActivitiesUseCase.invoke(GetLocalActivitiesUseCase.Params())).thenReturn(
            flowOf(expected)
        )
        viewModel = HomeViewModel(
            getActivityUseCase,
            saveActivityUseCase,
            activityMapper,
            activityDomainMapper,
            getLocalActivitiesUseCase,
        )
    }

    @Test
    fun getLocalActivitiesTest() = runBlockingTest {

        val expected = createList()
        val activities = expected.map { activityMapper.toModel(it) }

        assertEquals(activities, viewModel.localActivityList.first())
        assertEquals(1, 1)
    }

    @Test
    fun getRandomActivityTest() = runBlockingTest {

        val currentList = createList().toMutableList()

        val responseModel = DemoDomainEntity(
            id = 5,
            accessibility = 1.8,
            activity = "Test activity",
            link = "Test link",
            key = "TK",
            participants = 7,
            price = 0.4,
            type = "Outside"
        )

        assertEquals(currentList.size, 3)
        `when`(getActivityUseCase.invokeSuspend(GetActivityUseCase.Params())).thenReturn(
            responseModel
        )
        `when`(saveActivityUseCase.invokeSuspend(SaveActivityUseCase.Params(responseModel))).thenReturn(
            currentList.add(responseModel)
        )
        viewModel.getRandomActivity()
        assertEquals(currentList.size, 4)
        assertTrue(currentList.contains(responseModel))
        assertEquals(viewModel.isLoading.first(), false)
    }

    @Test
    fun getRandomActivityErrorTest() = runBlocking {

        val currentList = createList().toMutableList()

        val responseModel = DemoDomainEntity(
            id = 5,
            accessibility = 1.8,
            activity = "Test activity",
            link = "Test link",
            key = "TK",
            participants = 7,
            price = 0.4,
            type = "Outside"
        )

        assertEquals(currentList.size, 3)
        `when`(getActivityUseCase.invokeSuspend(GetActivityUseCase.Params())).thenReturn(null)
        viewModel.getRandomActivity()
        assertEquals(currentList.size, 3)
        assertFalse(currentList.contains(responseModel))
        assertEquals(viewModel.errorMsd.first(), "Error fetching new activity.")
        assertEquals(viewModel.isLoading.first(), false)
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
}
