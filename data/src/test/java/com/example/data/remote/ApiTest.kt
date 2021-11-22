package com.example.data.remote

import com.example.data.utils.MockRetrofitService
import com.example.data.utils.createResponseObject
import com.example.data.utils.testResponse
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import org.junit.Assert.assertEquals
import org.junit.Test
import java.net.HttpURLConnection

class ApiTest {

    private val api = MockRetrofitService.apiService

    private val response = testResponse
    private val expectResponseObject = createResponseObject()

    @Test
    fun shouldParseCorrectResponse() = runBlocking {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(response)
        MockRetrofitService.mockWebServer.enqueue(response)
        val result = api.getTrendingDay("key_test")
        assertEquals(result, expectResponseObject)
    }
}
