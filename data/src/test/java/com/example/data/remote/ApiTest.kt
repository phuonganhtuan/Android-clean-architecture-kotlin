package com.example.data.remote

import com.example.data.model.DemoEntity
import com.example.data.utils.MockRetrofitService
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import org.junit.Assert.assertEquals
import org.junit.Test
import java.net.HttpURLConnection

class ApiTest {

    private val api = MockRetrofitService.apiService

    private val testResponse =
        "{\"activity\":\"Study a foreign language\",\"type\":\"education\",\"participants\":1,\"price\":0,\"link\":\"\",\"key\":\"9765530\",\"accessibility\":0.1}"

    private val expectResponseObject = DemoEntity(
        id = null,
        activity = "Study a foreign language",
        type = "education",
        participants = 1,
        price = 0.0,
        link = "",
        key = "9765530",
        accessibility = 0.1,
    )

    @Test
    fun shouldParseCorrectResponse() = runBlocking {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(testResponse)
        MockRetrofitService.mockWebServer.enqueue(response)
        val activity = api.getRandomActivity()
        assertEquals(activity, expectResponseObject)
    }
}
