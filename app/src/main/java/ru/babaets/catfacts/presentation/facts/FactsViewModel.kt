package ru.babaets.catfacts.presentation.facts

import androidx.lifecycle.LiveData
import ru.babaets.catfacts.data.model.Fact
import ru.babaets.catfacts.presentation.common.IViewModel

interface FactsViewModel : IViewModel {

    val factLiveData: LiveData<Fact>

    val pictureLiveData: LiveData<String>

    fun onNewFactPressed()

    fun onHistoryPressed()

    fun onRetryPressed()
}
