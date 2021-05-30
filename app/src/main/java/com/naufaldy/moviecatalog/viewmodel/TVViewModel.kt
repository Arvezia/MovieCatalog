package com.naufaldy.moviecatalog.viewmodel

import androidx.lifecycle.ViewModel
import com.naufaldy.moviecatalog.data.ShowData
import com.naufaldy.moviecatalog.entity.TvEntity

class TVViewModel: ViewModel() {
    fun getTVShows(): List<TvEntity> = ShowData.generateTVShows()
}