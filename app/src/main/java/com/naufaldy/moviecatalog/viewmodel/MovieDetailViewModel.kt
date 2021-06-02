package com.naufaldy.moviecatalog.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naufaldy.moviecatalog.data.ShowData
import com.naufaldy.moviecatalog.data.source.MovieCatalogRepository
import com.naufaldy.moviecatalog.entity.MovieEntity

class MovieDetailViewModel(private val movieCatalogRepository: MovieCatalogRepository) : ViewModel(){
 lateinit var movieId: Int

 fun selectedMovie(movieId: Int){
  this.movieId = movieId
 }

 fun getMovieDetail(movieId: Int): LiveData<MovieEntity> =movieCatalogRepository.getMovieDetail(movieId)
}