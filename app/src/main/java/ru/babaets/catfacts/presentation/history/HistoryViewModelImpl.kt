package ru.babaets.catfacts.presentation.history

import androidx.lifecycle.MutableLiveData
import ru.babaets.catfacts.common.navigation.AppNavigator
import ru.babaets.catfacts.data.model.Fact
import ru.babaets.catfacts.presentation.common.BaseViewModel

class HistoryViewModelImpl(
    private val getFactsHistoryUseCase: GetFactsHistoryUseCase,
    navigator: AppNavigator
) : BaseViewModel(navigator), HistoryViewModel {

    override val factsLiveData = MutableLiveData<List<Fact>>()

    init {
        loadData()
    }

    override fun onRetryPressed() {
        loadData()
    }

    private fun loadData() {
        launchWithLoading {
            factsLiveData.postValue(getFactsHistoryUseCase.execute())
        }
    }
}
