package com.example.themoviedb.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.themoviedb.R
import com.example.themoviedb.viewModel.DetailsViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.details_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by viewModel()
    private var position : String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments?.let {
            position = DetailsFragmentArgs.fromBundle(it).moviePosition
        }

        viewModel.getDataFromArticle().observe(viewLifecycleOwner, Observer {
            Picasso.get().load("https://image.tmdb.org/t/p/w500"+it[position!!.toInt()].posterPath).into(iv_image)
            tv_title.text = it[position!!.toInt()].originalTitle
            tv_release_date.text = it[position!!.toInt()].releaseDate
            tv_overview.text = it[position!!.toInt()].overview
        })

    }

}
