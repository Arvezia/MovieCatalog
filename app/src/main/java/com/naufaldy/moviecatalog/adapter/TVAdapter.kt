package com.naufaldy.moviecatalog.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.naufaldy.moviecatalog.R
import com.naufaldy.moviecatalog.databinding.MovieListMenuBinding
import com.naufaldy.moviecatalog.detail.TVDetailActivity
import com.naufaldy.moviecatalog.entity.TvEntity

class TVAdapter: RecyclerView.Adapter<TVAdapter.ListViewHolder>() {
    private var tvList = ArrayList<TvEntity>()

    fun setTVList(lists: List<TvEntity>?){
        if (lists == null) return
        this.tvList.clear()
        this.tvList.addAll(lists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val tvListMenuBinding = MovieListMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(tvListMenuBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val list = tvList[position]
        holder.bind(list)
    }

    override fun getItemCount(): Int = tvList.size

    class ListViewHolder (private val binding: MovieListMenuBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(tvList: TvEntity) {
            with(binding){
                tvTitle.text = tvList.tvTitle
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, TVDetailActivity::class.java)
                    intent.putExtra(TVDetailActivity.EXTRA_TV, tvList.tvId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(tvList.tvPoster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_baseline_broken_image_24))
                    .into(CoverImg)
            }
        }
    }
}