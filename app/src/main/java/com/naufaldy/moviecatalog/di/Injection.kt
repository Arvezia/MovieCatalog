package com.naufaldy.moviecatalog.di

import android.content.Context
import com.naufaldy.moviecatalog.data.source.MovieCatalogRepository
import com.naufaldy.moviecatalog.data.source.remote.RemoteDataSource

object Injection {

        fun provideRepository(): MovieCatalogRepository {
            val remoteDataSource = RemoteDataSource.getInstance()
            return MovieCatalogRepository.getInstance(remoteDataSource)
        }


    }