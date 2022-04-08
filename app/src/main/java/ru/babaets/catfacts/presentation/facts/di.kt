package ru.babaets.catfacts.presentation.facts

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val factsModule = module {

    viewModel {
        FactsViewModelImpl(
            getNewFactUseCase = get(),
            navigator = get()
        )
    }

    factory<GetNewFactUseCase> {
        GetNewFactInteractor(
            api = get(),
            stringProvider = get()
        )
    }
}
