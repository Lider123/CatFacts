package ru.babaets.catfacts.presentation.history

import ru.babaets.catfacts.data.model.Fact

interface GetFactsHistoryUseCase {

    suspend fun execute(): List<Fact>
}
