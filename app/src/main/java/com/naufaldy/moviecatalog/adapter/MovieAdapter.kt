package com.naufaldy.moviecatalog.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.naufaldy.moviecatalog.R
import com.naufaldy.moviecatalog.databinding.MovieListMenuBinding
import com.naufaldy.moviecatalog.detail.MovieDetailActivity
import com.naufaldy.moviecatalog.entity.MovieEntity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {
    private var movieList = ArrayList<MovieEntity>()

    fun setMovieList(lists: List<MovieEntity>?){
        if (lists == null) return
        this.movieList.clear()
        this.movieList.addAll(lists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val movieListMenuBinding = MovieListMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(movieListMenuBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val list = movieList[position]
        holder.bind(list)
    }

    override fun getItemCount(): Int = movieList.size

    class ListViewHolder (private val binding: MovieListMenuBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(movieList: MovieEntity) {
            with(binding){
                tvTitle.text = movieList.movieTitle
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, MovieDetailActivity::class.java)
                    intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, movieList.movieId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(movieList.moviePoster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_baseline_broken_image_24))
                    .into(CoverImg)
            }
        }
    }
}