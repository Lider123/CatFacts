package ru.babaets.catfacts.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.babaets.catfacts.data.model.Fact

@Dao
interface FactDao {

    @Query("SELECT * FROM facts ORDER BY timestamp DESC")
    fun getAll(): List<Fact>

    @Insert
    fun insert(fact: Fact)
}
