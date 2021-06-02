package com.naufaldy.moviecatalog.data.source

import androidx.lifecycle.LiveData
import com.naufaldy.moviecatalog.data.ModelData
import com.naufaldy.moviecatalog.entity.MovieEntity
import com.naufaldy.moviecatalog.entity.TvEntity

interface MovieCatalogDataSource {
    fun getMovieList():LiveData<List<MovieEntity>>
    fun getTVShowList(): LiveData<List<TvEntity>>
    fun getMovieDetail(movieId: Int):LiveData<MovieEntity>
    fun getTVDetail(tvId: Int): LiveData<TvEntity>
}