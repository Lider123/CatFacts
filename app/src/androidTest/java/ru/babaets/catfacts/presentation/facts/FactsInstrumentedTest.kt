package ru.babaets.catfacts.presentation.facts

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.babaets.catfacts.R

@RunWith(AndroidJUnit4::class)
class FactsInstrumentedTest {

    private lateinit var scenario: FragmentScenario<FactsFragment>

    @Before
    fun before() {
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_CatFacts)
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun uiElements_areDisplayed_whenResumed() {
        onView(withId(R.id.ivPicture)).check(matches(isDisplayed()))
        onView(withId(R.id.btnNewFact)).check(matches(isDisplayed()))
        onView(withId(R.id.btnHistory)).check(matches(isDisplayed()))
        onView(withId(R.id.tvFact)).check(matches(isDisplayed()))
        onView(withId(R.id.tvUpdatedAt)).check(matches(isDisplayed()))
    }
}