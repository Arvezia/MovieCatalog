package com.naufaldy.moviecatalog.viewmodel

import androidx.lifecycle.ViewModel
import com.naufaldy.moviecatalog.data.ShowData
import com.naufaldy.moviecatalog.entity.MovieEntity
import com.naufaldy.moviecatalog.entity.TvEntity

class MovieViewModel: ViewModel() {
    fun getMovieShows(): List<MovieEntity> = ShowData.generateMovieShows()
}