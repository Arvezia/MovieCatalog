package com.naufaldy.moviecatalog.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.naufaldy.moviecatalog.R
import com.naufaldy.moviecatalog.databinding.ActivityTvDetailBinding
import com.naufaldy.moviecatalog.entity.MovieEntity
import com.naufaldy.moviecatalog.entity.TvEntity
import com.naufaldy.moviecatalog.viewmodel.MovieDetailViewModel
import com.naufaldy.moviecatalog.viewmodel.TVDetailViewModel

class TVDetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_TV = "extra_tv"
    }
    private lateinit var binding:ActivityTvDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TVDetailViewModel::class.java]

        val extras =intent.extras
        if(extras != null){
            val tvId = extras.getInt(TVDetailActivity.EXTRA_TV)
            if (tvId != null){
                viewModel.selectedTVShows(tvId)
                gettv(viewModel.getTVDetail() as TvEntity)
            }
        }
    }
    private fun gettv(tvEntity: TvEntity){
        binding.tvTitle.text = tvEntity.tvTitle
        binding.tvSynopsis.text = tvEntity.tvSynopsis
        Glide.with(this)
            .load(tvEntity.tvPoster)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_baseline_broken_image_24))
            .into(binding.tvCover)
    }
}
