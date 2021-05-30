package com.naufaldy.moviecatalog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naufaldy.moviecatalog.databinding.ActivityMovieDetailBinding

class MovieDetailAdapter : RecyclerView.Adapter<MovieDetailAdapter.ListViewHolder>() {
    class ListViewHolder(private val binding: ActivityMovieDetailBinding): RecyclerView.ViewHolder(binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val movieDetailBinding = ActivityMovieDetailBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ListViewHolder(movieDetailBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        //val list = movi
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}