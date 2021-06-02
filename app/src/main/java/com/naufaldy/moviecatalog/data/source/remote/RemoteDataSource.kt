package com.naufaldy.moviecatalog.data.source.remote


import com.naufaldy.moviecatalog.data.source.remote.api.ApiConfig
import com.naufaldy.moviecatalog.data.source.remote.response.MovieResponse
import com.naufaldy.moviecatalog.data.source.remote.response.TVShowsResponse
import com.naufaldy.moviecatalog.utils.EspressoIdlingResources
import retrofit2.await

class RemoteDataSource {

    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }
    suspend fun getMovieShows(callback: LoadMoviesCallback){
        EspressoIdlingResources.increment()
        ApiConfig.instance.getMovieList().await().let { listMovie -> callback.moviesReceived(listMovie)
            EspressoIdlingResources.decrement()
        }
    }
   suspend fun getTVShows(callback: LoadTVCallback){
        EspressoIdlingResources.increment()
        ApiConfig.instance.getTvShowList().await().let { listTVShows -> callback.tvReceived(listTVShows)
            EspressoIdlingResources.decrement()
        }
    }
   suspend fun getMovieDetail(callback: LoadMovieDetail, movieId: Int){
        EspressoIdlingResources.increment()
        ApiConfig.instance.getDetailMovie(movieId).await().let { movieDetail -> callback.movieDetailReceived(movieDetail)
            EspressoIdlingResources.decrement()
        }
    }
   suspend fun getTVDetail(callback: LoadTVDetail, tvId: Int){
        EspressoIdlingResources.increment()
        ApiConfig.instance.getDetailTvShow(tvId).await().let { tvDetail -> callback.tvDetailReceived(tvDetail)
            EspressoIdlingResources.decrement()
        }
    }

    interface LoadMoviesCallback{
        fun moviesReceived(movieResponse: List<MovieResponse>)
    }
    interface LoadTVCallback{
        fun tvReceived(tvShowsResponse: List<TVShowsResponse>)
    }
    interface LoadMovieDetail{
        fun movieDetailReceived(movieResponse: MovieResponse)
    }
    interface LoadTVDetail{
        fun tvDetailReceived(tvShowsResponse: TVShowsResponse)
    }
}