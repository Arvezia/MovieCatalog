package com.naufaldy.moviecatalog.viewmodel

import com.naufaldy.moviecatalog.entity.MovieEntity
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp(){
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovieShows() {
        val getMovies = viewModel.getMovieShows()
        assertNotNull(getMovies)
        assertEquals(10, getMovies.size)
    }
}