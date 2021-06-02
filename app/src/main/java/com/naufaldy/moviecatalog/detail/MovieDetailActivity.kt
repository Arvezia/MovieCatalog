package com.naufaldy.moviecatalog.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.naufaldy.moviecatalog.R
import com.naufaldy.moviecatalog.adapter.MovieAdapter
import com.naufaldy.moviecatalog.adapter.MovieDetailAdapter
import com.naufaldy.moviecatalog.databinding.ActivityMovieDetailBinding
import com.naufaldy.moviecatalog.entity.MovieEntity
import com.naufaldy.moviecatalog.viewmodel.MovieDetailViewModel
import com.naufaldy.moviecatalog.viewmodel.ViewModelFactory

class MovieDetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_MOVIE = "extra_movie"
    }
    private lateinit var binding: ActivityMovieDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val adapter = MovieAdapter()
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[MovieDetailViewModel::class.java]

        val extras =intent.extras
        if(extras != null){
            val movieId = extras.getInt(EXTRA_MOVIE)
            if (movieId != null){
                viewModel.selectedMovie(movieId)
                getMovie(viewModel.getMovieDetail() as MovieEntity)
            }
        }
    }
    private fun getMovie(movieEntity: MovieEntity){
        binding.movieTitle.text = movieEntity.movieTitle
        binding.movieSynopsis.text = movieEntity.movieSynopsis
        Glide.with(this)
            .load(movieEntity.moviePoster)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_baseline_broken_image_24))
            .into(binding.movieCover)
    }
}