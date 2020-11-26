package com.example.spaceflightnews.data

import retrofit2.Call
import retrofit2.http.GET

interface MainApi {

    companion object {
        const val BASE_URL = "https://www.spaceflightnewsapi.net/"
    }

    @GET("api/v2/articles")
    fun getArticles(): Call<List<Article>>
}