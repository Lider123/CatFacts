package ru.babaets.catfacts.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import org.koin.android.ext.android.inject
import ru.babaets.catfacts.R
import ru.babaets.catfacts.common.navigation.AppNavigator

class MainActivity : AppCompatActivity() {

    private val navigator: AppNavigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigator.controller = findNavController(R.id.fragmentNavHost)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.fragmentNavHost).navigateUp()
}
