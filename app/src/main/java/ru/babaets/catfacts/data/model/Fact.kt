package ru.babaets.catfacts.data.model

import com.squareup.moshi.Json

data class Fact(
    @Json(name = "_id") val id: String,
    @Json(name = "text") val text: String,
    @Json(name = "updatedAt") val updatedAtString: String
)
