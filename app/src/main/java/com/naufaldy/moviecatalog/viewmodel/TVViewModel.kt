package com.naufaldy.moviecatalog.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.naufaldy.moviecatalog.data.ShowData
import com.naufaldy.moviecatalog.data.source.MovieCatalogRepository
import com.naufaldy.moviecatalog.entity.TvEntity

class TVViewModel(private val movieCatalogRepository: MovieCatalogRepository): ViewModel() {
    fun getTVShows():LiveData< List<TvEntity>> = movieCatalogRepository.getTVShowList()
}