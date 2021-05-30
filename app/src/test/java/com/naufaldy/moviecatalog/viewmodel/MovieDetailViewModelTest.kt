package com.naufaldy.moviecatalog.viewmodel

import com.naufaldy.moviecatalog.data.ShowData
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieDetailViewModelTest {
    private lateinit var viewModel: MovieDetailViewModel
    private val dummyMovies = ShowData.generateMovieShows()[0]
    private val moviesId =dummyMovies.movieId

    @Before
    fun setUp(){
        viewModel = MovieDetailViewModel()
        viewModel.selectedMovie(moviesId)
    }


    @Test
    fun getMovie() {
        viewModel.selectedMovie(dummyMovies.movieId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovies.movieId, movieEntity.movieId)
        assertEquals(dummyMovies.moviePoster, movieEntity.moviePoster)
        assertEquals(dummyMovies.movieSynopsis, movieEntity.movieSynopsis)
        assertEquals(dummyMovies.movieTitle, movieEntity.movieTitle)

    }
}