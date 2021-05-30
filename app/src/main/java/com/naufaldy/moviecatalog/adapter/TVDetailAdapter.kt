package com.naufaldy.moviecatalog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.naufaldy.moviecatalog.R
import com.naufaldy.moviecatalog.databinding.ActivityTvDetailBinding
import com.naufaldy.moviecatalog.databinding.MovieListMenuBinding
import com.naufaldy.moviecatalog.entity.TvEntity

class TVDetailAdapter: RecyclerView.Adapter<TVDetailAdapter.ListViewHolder>()  {
    private val tvShowsLists = ArrayList<TvEntity>()

    fun setTVList(lists: List<TvEntity>?){
        if (lists == null) return
        this.tvShowsLists.clear()
        this.tvShowsLists.addAll(lists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
    class ListViewHolder (private val binding: ActivityTvDetailBinding): RecyclerView.ViewHolder(binding.root){

    }
}