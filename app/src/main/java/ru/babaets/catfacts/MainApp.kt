package ru.babaets.catfacts

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.babaets.catfacts.common.appModule
import ru.babaets.catfacts.data.db.dbModule
import ru.babaets.catfacts.data.network.networkModule
import ru.babaets.catfacts.presentation.facts.factsModule

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MainApp)
            modules(
                appModule,
                networkModule,
                dbModule,
                factsModule,
                //historyModule
            )
        }
    }
}
