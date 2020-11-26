package com.example.spaceflightnews.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainRepository {

    private val coroutineContext = Dispatchers.IO
    private val mainApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(MainApi.BASE_URL)
        .build()
        .create(MainApi::class.java)

    suspend fun getArticles() = withContext(coroutineContext) {
        mainApi.getArticles()
            .execute()
            .body()
    }
}