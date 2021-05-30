package com.naufaldy.moviecatalog.viewmodel

import com.naufaldy.moviecatalog.data.ShowData
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TVDetailViewModelTest {
    private lateinit var viewModel: TVDetailViewModel
    private val dummyTVShows = ShowData.generateTVShows()[0]
    private val tvId = dummyTVShows.tvId

    @Before
    fun setUp(){
        viewModel = TVDetailViewModel()
        viewModel.selectedTVShows(tvId)
    }

    @Test
    fun getTVShows() {
        viewModel.selectedTVShows(dummyTVShows.tvId)
        val tvEntity = viewModel.getTVShows()
        assertNotNull(tvEntity)
        assertEquals(dummyTVShows.tvId, tvEntity.tvId)
        assertEquals(dummyTVShows.tvPoster, tvEntity.tvPoster)
        assertEquals(dummyTVShows.tvSynopsis, tvEntity.tvSynopsis)
        assertEquals(dummyTVShows.tvTitle, tvEntity.tvTitle)
    }
}