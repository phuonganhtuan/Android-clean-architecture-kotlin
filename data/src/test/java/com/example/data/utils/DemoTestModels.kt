package com.example.data.utils

import com.example.data.model.DemoEntity

fun createList(): List<DemoEntity> {
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
