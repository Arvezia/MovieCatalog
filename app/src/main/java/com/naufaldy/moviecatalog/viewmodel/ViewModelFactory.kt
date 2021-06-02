package com.naufaldy.moviecatalog.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.naufaldy.moviecatalog.data.source.MovieCatalogRepository
import com.naufaldy.moviecatalog.di.Injection

class ViewModelFactory private constructor(private val movieCatalogRepository: MovieCatalogRepository): ViewModelProvider.NewInstanceFactory(){
    companion object{
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance?: synchronized(this){
                instance?: ViewModelFactory(Injection.provideRepository())
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       when{
            modelClass.isAssignableFrom(MovieViewModel::class.java)->{
                return MovieViewModel(movieCatalogRepository) as T
            }
            modelClass.isAssignableFrom(TVViewModel::class.java)->{
                return TVViewModel(movieCatalogRepository) as T
            }
            modelClass.isAssignableFrom(MovieDetailViewModel::class.java)->{
                return MovieDetailViewModel(movieCatalogRepository) as T
            }
            modelClass.isAssignableFrom(TVDetailViewModel::class.java)->{
                return TVDetailViewModel(movieCatalogRepository) as T
            }
           else -> throw Throwable("Unknown Viewmodel class: "+ modelClass.name)
        }
    }
}