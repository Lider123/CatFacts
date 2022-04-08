package ru.babaets.catfacts.data.db

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {

    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "app-db")
            .build()
    }
}
