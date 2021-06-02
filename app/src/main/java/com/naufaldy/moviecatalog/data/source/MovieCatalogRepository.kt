package com.naufaldy.moviecatalog.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.naufaldy.moviecatalog.data.ModelData
import com.naufaldy.moviecatalog.data.source.remote.RemoteDataSource
import com.naufaldy.moviecatalog.data.source.remote.response.MovieResponse
import com.naufaldy.moviecatalog.data.source.remote.response.TVShowsResponse
import com.naufaldy.moviecatalog.entity.MovieEntity
import com.naufaldy.moviecatalog.entity.TvEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MovieCatalogRepository private constructor(private val remoteDataSource: RemoteDataSource) : MovieCatalogDataSource{

    companion object{
        @Volatile
        private var instance: MovieCatalogRepository? null

        fun getInstance(remoteData: RemoteDataSource): MovieCatalogRepository =
            instance ?: synchronized(this){
            instance ?: MovieCatalogRepository(remoteData).apply { instance = this }
        }
    }

    override fun getMovieList(): LiveData<List<MovieEntity>> {
        val movieResult = MutableLiveData<List<MovieEntity>>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getMovieShows(object : RemoteDataSource.LoadMoviesCallback {
                override fun moviesReceived(movieResponse: List<MovieResponse>) {
                    val movieList = ArrayList<MovieEntity>()
                    for (mResponse in movieResponse) {
                        val movie = MovieEntity(
                            mResponse.id,
                            mResponse.title,
                            mResponse.synopsis,
                            mResponse.poster
                        )
                        movieList.add(movie)
                    }
                    movieResult.postValue(movieList)
                }
            })
        }
            return movieResult
    }

    override fun getTVShowList(): LiveData<List<TvEntity>> {
        val tvResult = MutableLiveData<List<TvEntity>>()
       CoroutineScope(Dispatchers.IO).launch {
           remoteDataSource.getTVShows(object : RemoteDataSource.LoadTVCallback{
               override fun tvReceived(tvShowsResponse: List<TVShowsResponse>) {
                   val tvList = ArrayList<TvEntity>()
                   for (tResponse in tvShowsResponse){
                       val tvShows = TvEntity(
                           tResponse.id,
                           tResponse.title,
                           tResponse.synopsis,
                           tResponse.poster
                       )
                       tvList.add(tvShows)
                   }
                   tvResult.postValue(tvList)
               }
           })
       }
        return tvResult
    }

    override fun getMovieDetail(movieId: Int): LiveData<MovieEntity> {
        val movieDetailResult = MutableLiveData<MovieEntity>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getMovieDetail(object : RemoteDataSource.LoadMovieDetail{
                override fun movieDetailReceived(movieResponse: MovieResponse) {
                    val movieDetail = MovieEntity(
                        movieResponse.id,
                        movieResponse.title,
                        movieResponse.synopsis,
                        movieResponse.poster
                    )
                    movieDetailResult.postValue(movieDetail)
                }
            })
        }
        return movieDetailResult
    }

    override fun getTVDetail(tvId: Int): LiveData<TvEntity> {
        val tvDetailResult = MutableLiveData<TvEntity>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getTVDetail(object: RemoteDataSource.LoadTVDetail{
                override fun tvDetailReceived(tvShowsResponse: TVShowsResponse) {
                    val tvDetail = TvEntity(
                        tvShowsResponse.id,
                        tvShowsResponse.title,
                        tvShowsResponse.synopsis,
                        tvShowsResponse.poster
                    )
                    tvDetailResult.postValue(tvDetail)
                }
            })
        }
        return tvDetailResult
    }
}