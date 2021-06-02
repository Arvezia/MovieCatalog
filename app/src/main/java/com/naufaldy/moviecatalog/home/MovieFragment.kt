package com.naufaldy.moviecatalog.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufaldy.moviecatalog.R
import com.naufaldy.moviecatalog.adapter.MovieAdapter
import com.naufaldy.moviecatalog.databinding.FragmentMovieBinding
import com.naufaldy.moviecatalog.databinding.MovieListMenuBinding
import com.naufaldy.moviecatalog.viewmodel.MovieViewModel
import com.naufaldy.moviecatalog.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {
    private lateinit var fragmentActivityBinding: FragmentMovieBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentActivityBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentActivityBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            val movieAdapter = MovieAdapter()

            viewModel.getMovieShows().observe(viewLifecycleOwner,Observer {movieList ->
                movieAdapter.setMovieList(movieList)
            })

            with(fragmentActivityBinding.rvMovie){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }


}