package com.example.themoviedb.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager

import com.example.themoviedb.R
import com.example.themoviedb.model.network.InternetCheck
import com.example.themoviedb.viewModel.MovieViewModel
import kotlinx.android.synthetic.main.movie_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {


    private val viewModel: MovieViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.setHasFixedSize(true)
        swipeRefreshLayout.isEnabled = false
        InternetCheck{internet ->
            if (!internet){
                Toast.makeText(context,"Нет подключения к интернету!", Toast.LENGTH_SHORT).show()
            }else{
                loadMore()
                swipeRefreshLayout.isEnabled = true
            }
        }
        viewModel.getDataFromArticle().observe(viewLifecycleOwner, Observer {
            recyclerView.adapter = MovieAdapter(it)
        })

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = true
            loadMore()
        }

    }

    private fun loadMore() {
        viewModel.putDataToResults()
        swipeRefreshLayout.isRefreshing = false
    }

}
