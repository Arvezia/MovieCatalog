package com.naufaldy.moviecatalog.viewmodel

import androidx.lifecycle.ViewModel
import com.naufaldy.moviecatalog.data.ShowData
import com.naufaldy.moviecatalog.entity.MovieEntity

class MovieDetailViewModel : ViewModel(){
    private lateinit var movieId: String


    fun selectedMovie(movieId: String){
        this.movieId = movieId
    }
    fun getMovie(): MovieEntity{
        lateinit var movie: MovieEntity
        val movieEntities = ShowData.generateMovieShows()
        for (movieEntity in movieEntities){
            if (movieEntity.movieId == movieId){
                movie = movieEntity
            }
        }
        return movie
    }
}