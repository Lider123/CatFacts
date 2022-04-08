package ru.babaets.catfacts.presentation.history

import androidx.lifecycle.LiveData
import ru.babaets.catfacts.data.model.Fact
import ru.babaets.catfacts.presentation.common.IViewModel

interface HistoryViewModel : IViewModel {

    val factsLiveData: LiveData<List<Fact>>

    fun onRetryPressed()
}
