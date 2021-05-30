package com.naufaldy.moviecatalog

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.google.android.material.tabs.TabLayout
import com.naufaldy.moviecatalog.data.ShowData
import com.naufaldy.moviecatalog.utils.EspressoIdlingResources
import org.hamcrest.CoreMatchers
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

class MainActivityTest {
    private val dummyMovie = ShowData.generateMovieShows()
    private val dummyTV = ShowData.generateTVShows()

    @Before
    fun before() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }

    @After
    fun after() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }

    private fun selectTabAtPosition(tabIndex: Int): ViewAction {
        return object : ViewAction {
            override fun getDescription() = "with tab at index $tabIndex"

            override fun getConstraints() = CoreMatchers.allOf(
                isDisplayed(),
                isAssignableFrom(TabLayout::class.java)
            )

            override fun perform(uiController: UiController, view: View) {
                val tabLayout = view as TabLayout
                val tabAtIndex: TabLayout.Tab = tabLayout.getTabAt(tabIndex)
                    ?: throw PerformException.Builder()
                        .withCause(Throwable("No tab at index $tabIndex"))
                        .build()

                tabAtIndex.select()
            }
        }
    }

    fun waitFor(delay: Long): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return isRoot()
            }

            override fun getDescription(): String {
                return "wait for " + delay + "milliseconds"
            }

            override fun perform(uiController: UiController, view: View) {
                uiController.loopMainThreadForAtLeast(delay)
            }
        }
    }

    @Test
    fun checkTabLayout() {
        onView(withId(R.id.tabs)).check(matches(isDisplayed()))
        onView(withId(R.id.tabs)).perform(selectTabAtPosition(0))
        onView(withId(R.id.tabs)).perform(selectTabAtPosition(1))
    }

    @Test
    fun onLoadMovies() {
        onView(withId(R.id.tabs)).perform(selectTabAtPosition(0))
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }
    @Test
    fun onLoadTVShows() {
        onView(withId(R.id.tabs)).perform(selectTabAtPosition(1))
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTV.size))
    }
    @Test
    fun onLoadMovieDetail() {
        onView(withId(R.id.tabs)).perform(selectTabAtPosition(0))
        onView(isRoot()).perform(waitFor(500))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        onView(withId(R.id.movie_cover)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_title)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_title)).check(matches(withText(dummyMovie[0].movieTitle)))
        onView(withId(R.id.movie_synopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_synopsis)).check(matches(withText(dummyMovie[0].movieSynopsis)))
    }
    @Test
    fun onLoadTVDetail() {
        onView(withId(R.id.tabs)).perform(selectTabAtPosition(1))
        onView(isRoot()).perform(waitFor(500))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,click()))
        onView(withId(R.id.tv_cover)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTV[0].tvTitle)))
        onView(withId(R.id.tv_synopsis)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_synopsis)).check(matches(withText(dummyTV[0].tvSynopsis)))
    }
}