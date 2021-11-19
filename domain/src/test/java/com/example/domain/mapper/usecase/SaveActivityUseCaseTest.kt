package com.example.domain.mapper.usecase

import com.example.data.model.DemoEntity
import com.example.data.repository.MainRepository
import com.example.data.mapper.toData.ActivityEntityMapper
import com.example.domain.model.DemoDomainEntity
import com.example.domain.usecase.SaveActivityUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class SaveActivityUseCaseTest {

    private val demoEntity = DemoEntity(
        id = 1,
        accessibility = 1.5,
        activity = "Test activity",
        link = "Test link",
        key = "TK",
        participants = 4,
        price = 0.0,
        type = "Outside"
    )

    private val demoDomainEntity = DemoDomainEntity(
        id = 1,
        accessibility = 1.5,
        activity = "Test activity",
        link = "Test link",
        key = "TK",
        participants = 4,
        price = 0.0,
        type = "Outside"
    )

    @Mock
    private lateinit var repository: MainRepository

    private val activityEntityMapper = ActivityEntityMapper()

    private lateinit var saveActivityUseCase: SaveActivityUseCase

    @Before
    fun setupData() {
        MockitoAnnotations.initMocks(this)
        saveActivityUseCase = SaveActivityUseCase(repository, activityEntityMapper)
    }

    @Test
    fun getActivityTest() = runBlocking {
        Mockito.`when`(repository.addEntity(demoEntity)).thenReturn(Unit)
        Assert.assertNotNull(
            saveActivityUseCase.invokeSuspend(
                SaveActivityUseCase.Params(
                    demoDomainEntity
                )
            )
        )
    }
}
