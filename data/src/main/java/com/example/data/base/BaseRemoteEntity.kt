package com.example.data.base

data class BaseRemoteEntity<T>(
    val results: T?,
    val page: Int?,
    val total_results: Int?,
)
