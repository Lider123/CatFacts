package ru.babaets.catfacts.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.babaets.catfacts.data.model.Fact

@Database(entities = [Fact::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun factDao(): FactDao
}
