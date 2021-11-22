package com.example.data.datasource.local.impl

import com.example.data.datasource.local.dao.DemoDao
import com.example.data.datasource.local.datasource.MainLocalDataSource
import javax.inject.Inject

class MainLocalDataSourceImpl @Inject constructor(private val dao: DemoDao) : MainLocalDataSource {

}
