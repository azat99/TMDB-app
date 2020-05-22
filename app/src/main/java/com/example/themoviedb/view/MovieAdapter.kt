package com.example.themoviedb.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.R
import com.example.themoviedb.model.entities.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*

class MovieAdapter(private val list: List<Result>) :
    RecyclerView.Adapter<MovieAdapter.NewsViewHolder>() {
    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val holder = NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
        return holder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+list[position].posterPath).into(holder.itemView.iv_image)
        holder.itemView.setOnClickListener {
            val action = MovieFragmentDirections.actionMovieFragmentToDetailsFragment()
            action.moviePosition = position.toString()
            Navigation.findNavController(it).navigate(action)
        }
    }

}