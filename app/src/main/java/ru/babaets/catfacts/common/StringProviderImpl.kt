package ru.babaets.catfacts.common

import android.content.res.Resources
import ru.babaets.catfacts.R

class StringProviderImpl(resources: Resources) : StringProvider {
    override val GET_FACT_ERROR: String = resources.getString(R.string.get_fact_error)
    override val EMPTY_HISTORY_ERROR: String = resources.getString(R.string.empty_history_error)
    override val GET_FACTS_HISTORY_ERROR: String = resources.getString(R.string.get_facts_history_error)
}
