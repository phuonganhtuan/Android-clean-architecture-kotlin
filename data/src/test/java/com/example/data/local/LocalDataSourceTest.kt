package com.example.data.local

import com.example.data.datasource.local.dao.DemoDao
import com.example.data.datasource.local.impl.MainLocalDataSourceImpl
import com.example.data.model.DemoEntity
import com.example.data.utils.createList
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
class LocalDataSourceTest {

    val demoEntity = DemoEntity(
        id = 5,
        accessibility = 1.8,
        activity = "Test activity",
        link = "Test link",
        key = "TK",
        participants = 7,
        price = 0.4,
        type = "Outside"
    )

    @Mock
    private lateinit var dao: DemoDao

    private lateinit var dataSource: MainLocalDataSourceImpl

    @Before
    fun setupData() {
        runBlocking {
            MockitoAnnotations.initMocks(this)
            dataSource = MainLocalDataSourceImpl(dao)
            Mockito.`when`(dao.getAllEntities()).thenReturn(flowOf(createList()))
            Mockito.`when`(dao.addEntity(demoEntity)).thenReturn(Unit)
        }
    }

    @Test
    fun getLocalActivitiesTest() = runBlocking {
        val result = dataSource.getAllEntities()
        Assert.assertEquals(createList(), result.first())
    }

    @Test
    fun saveActivityTest() = runBlocking {
        Assert.assertNotNull(dataSource.addEntity(demoEntity))
    }
}
