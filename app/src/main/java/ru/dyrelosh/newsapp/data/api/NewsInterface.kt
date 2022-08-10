package ru.dyrelosh.newsapp.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.dyrelosh.newsapp.utils.Constants

interface NewsInterface {

    @GET("/v2/everything")
    suspend fun getEverything(
        @Query("q") query: String,
        @Query("page") page: String,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    )

    @GET("/v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country") country: String = "ru",
        @Query("page") page: String,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    )
}