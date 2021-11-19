package com.example.demo_clean_arch.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ActivityModelTest {

    private lateinit var activityModel: ActivityModel

    private val displayString =
        "id: 1\nAccessibility: 1.5\nActivity: Test activity\nKey: TK\nLink: Test link\nParticipants: 4\nPrice: 0.0\nType: Outside"

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
    }

    @Test
    fun displayStringTest() {
        val stringResult = activityModel.displayString
        Assert.assertEquals(displayString, stringResult)
    }
}
