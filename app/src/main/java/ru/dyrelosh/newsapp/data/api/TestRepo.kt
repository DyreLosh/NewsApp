package ru.dyrelosh.newsapp.data.api

import javax.inject.Inject

class TestRepo @Inject constructor(private val newsInterface: NewsInterface) {
    suspend fun getAll() = newsInterface.getHeadlines()
}