package com.naufaldy.moviecatalog.viewmodel

import androidx.lifecycle.ViewModel
import com.naufaldy.moviecatalog.data.ShowData
import com.naufaldy.moviecatalog.entity.MovieEntity
import com.naufaldy.moviecatalog.entity.TvEntity

class TVDetailViewModel :ViewModel(){
    private lateinit var tvId: String


    fun selectedTVShows(tvId: String){
        this.tvId = tvId
    }
    fun getTVShows(): TvEntity {
        lateinit var tv: TvEntity
        val tvEntities = ShowData.generateTVShows()
        for (tvEntity in tvEntities){
            if (tvEntity.tvId == tvId){
                tv = tvEntity
            }
        }
        return tv
    }
}
