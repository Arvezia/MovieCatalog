package com.naufaldy.moviecatalog.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufaldy.moviecatalog.R
import com.naufaldy.moviecatalog.adapter.MovieAdapter
import com.naufaldy.moviecatalog.adapter.TVAdapter
import com.naufaldy.moviecatalog.databinding.FragmentMovieBinding
import com.naufaldy.moviecatalog.databinding.FragmentTvBinding
import com.naufaldy.moviecatalog.viewmodel.MovieViewModel
import com.naufaldy.moviecatalog.viewmodel.TVViewModel
import com.naufaldy.moviecatalog.viewmodel.ViewModelFactory


class TVFragment : Fragment() {
    private lateinit var fragmentTvBinding: FragmentTvBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTvBinding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return fragmentTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TVViewModel::class.java]
            val tvAdapter = TVAdapter()
            viewModel.getTVShows().observe(viewLifecycleOwner,{tvshows ->
                tvAdapter.setTVList(tvshows)
            })

            with(fragmentTvBinding.rvTv){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvAdapter
            }
        }
    }

}