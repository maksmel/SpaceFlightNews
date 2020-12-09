package com.example.spaceflightnews.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class Article(
    val id: String,
    val title: String,
    val newsSite: String,
    val summary: String,
    @SerializedName("publishedAt") val dateTime: Date,
    val imageUrl: String
): Serializable

data class Blog(
    val id: String,
    val title: String,
    val newsSite: String,
    val summary: String,
    @SerializedName("publishedAt") val dateTime: Date,
    val imageUrl: String
)