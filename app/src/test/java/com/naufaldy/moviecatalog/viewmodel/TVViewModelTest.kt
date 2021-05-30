package com.naufaldy.moviecatalog.viewmodel

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TVViewModelTest {
    private lateinit var viewModel: TVViewModel

    @Before
    fun setUp(){
        viewModel = TVViewModel()
    }

    @Test
    fun getTVShows() {
        val getTV = viewModel.getTVShows()
        assertNotNull(getTV)
        assertEquals(10, getTV.size)
    }
}