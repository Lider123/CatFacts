package ru.babaets.catfacts.presentation.history

import ru.babaets.catfacts.common.StringProvider
import ru.babaets.catfacts.common.exception.EmptyDataException
import ru.babaets.catfacts.common.exception.FetchDataException
import ru.babaets.catfacts.data.db.AppDatabase
import ru.babaets.catfacts.data.model.Fact

class GetFactsHistoryInteractor(
    private val db: AppDatabase,
    private val stringProvider: StringProvider
) : GetFactsHistoryUseCase {

    override suspend fun execute(): List<Fact> =
        try {
            val facts = db.factDao().getAll()
            if (facts.isEmpty()) throw EmptyDataException(stringProvider.EMPTY_HISTORY_ERROR)

            facts
        } catch (e: Exception) {
            throw FetchDataException(stringProvider.GET_FACTS_HISTORY_ERROR, e)
        }
}
