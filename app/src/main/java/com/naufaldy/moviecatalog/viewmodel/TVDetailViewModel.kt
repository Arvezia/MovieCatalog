package com.naufaldy.moviecatalog.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naufaldy.moviecatalog.data.ShowData
import com.naufaldy.moviecatalog.data.source.MovieCatalogRepository
import com.naufaldy.moviecatalog.entity.MovieEntity
import com.naufaldy.moviecatalog.entity.TvEntity

class TVDetailViewModel(private val movieCatalogRepository: MovieCatalogRepository) :ViewModel(){
    lateinit var tvId: Int
    fun selectedTVShows(tvId: Int){
        this.tvId = tvId
    }

    fun getTVDetail(tvId: Int): LiveData<TvEntity> = movieCatalogRepository.getTVDetail(tvId)
}
