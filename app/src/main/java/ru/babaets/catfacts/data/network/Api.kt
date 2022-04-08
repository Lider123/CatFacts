package ru.babaets.catfacts.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import ru.babaets.catfacts.data.model.Fact

interface Api {

    @GET("/facts/random")
    suspend fun getRandomFacts(
        @Query("animal_type") animalType: String,
        @Query("amount") amount: Int
    ): Fact
}
