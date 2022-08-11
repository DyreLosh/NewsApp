package ru.dyrelosh.newsapp.data.api

import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsInterface: NewsInterface) {
    suspend fun getNews(country: String, pageNumber: Int) =
        newsInterface.getHeadlines(country, pageNumber)

    suspend fun searchNews(query: String, pageNumber: Int) =
        newsInterface.getEverything(query, pageNumber)
}