package ru.babaets.catfacts.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "facts")
data class Fact(

    @Json(name = "_id")
    @PrimaryKey
    val id: String,

    @Json(name = "text")
    @ColumnInfo(name = "text")
    val text: String,

    @Json(name = "updatedAt")
    @ColumnInfo(name = "updated_at")
    val updatedAt: String,

    @ColumnInfo(name = "timestamp")
    val dbTimestamp: String?
)
