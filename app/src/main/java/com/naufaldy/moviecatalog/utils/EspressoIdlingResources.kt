package com.naufaldy.moviecatalog.utils

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResources {
        private val RESOURCE: String = "GLOBAL"
        val idlingResource = CountingIdlingResource(RESOURCE)
        fun increment() {
            idlingResource.increment()
        }

        fun decrement() {
            idlingResource.decrement()
        }
    }
