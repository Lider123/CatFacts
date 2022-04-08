package ru.babaets.catfacts.common

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.babaets.catfacts.common.navigation.AppNavigator
import ru.babaets.catfacts.common.navigation.AppNavigatorImpl

val appModule = module {

    single<AppNavigator> {
        AppNavigatorImpl()
    }

    single<StringProvider> {
        StringProviderImpl(
            resources = androidContext().resources
        )
    }
}
