package ru.babaets.catfacts.presentation.facts

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import ru.babaets.catfacts.BuildConfig
import ru.babaets.catfacts.common.navigation.AppNavigator
import ru.babaets.catfacts.data.model.Fact
import ru.babaets.catfacts.presentation.common.BaseViewModel

class FactsViewModelImpl(
    private val getNewFactUseCase: GetNewFactUseCase,
    navigator: AppNavigator
) : BaseViewModel(navigator), FactsViewModel {

    override val factLiveData = MutableLiveData<Fact>()

    override val pictureLiveData = MutableLiveData<String>()

    init {
        loadData()
    }

    override fun onNewFactPressed() {
        loadData()
    }

    override fun onRetryPressed() {
        loadData()
    }

    private fun loadData() {
        launchWithLoading(Dispatchers.IO) {
            factLiveData.postValue(getNewFactUseCase.execute())
            pictureLiveData.postValue(BuildConfig.IMAGE_URL)
        }
    }
}
