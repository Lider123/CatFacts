package ru.babaets.catfacts.presentation.history

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val historyModule = module {

    viewModel {
        HistoryViewModelImpl(
            getFactsHistoryUseCase = get(),
            navigator = get()
        )
    }

    factory<GetFactsHistoryUseCase> {
        GetFactsHistoryInteractor(
            db = get(),
            stringProvider = get()
        )
    }
}
