package ru.babaets.catfacts.presentation.facts

import ru.babaets.catfacts.common.StringProvider
import ru.babaets.catfacts.common.exception.FetchDataException
import ru.babaets.catfacts.data.model.Fact
import ru.babaets.catfacts.data.network.Api

class GetNewFactInteractor(
    private val api: Api,
    private val stringProvider: StringProvider
) : GetNewFactUseCase {

    override suspend fun execute(): Fact =
        try {
            api.getRandomFacts(
                animalType = "cat",
                amount = 1
            )
        } catch (e: Exception) {
            throw FetchDataException(stringProvider.GET_FACT_ERROR, e)
        }
}
