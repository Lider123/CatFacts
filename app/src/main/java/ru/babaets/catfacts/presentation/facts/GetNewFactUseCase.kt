package ru.babaets.catfacts.presentation.facts

import ru.babaets.catfacts.data.model.Fact

interface GetNewFactUseCase {

    suspend fun execute(): Fact
}
