package ru.babaets.catfacts.presentation.common

import androidx.lifecycle.LiveData

interface IViewModel {

    val progressLiveData: LiveData<Boolean>

    val errorLiveData: LiveData<Throwable?>

    fun onBackPressed()
}
