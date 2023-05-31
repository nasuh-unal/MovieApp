package com.example.movieapp.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.MovieItemDesingBinding
import com.example.movieapp.network.MovieDataModel
import com.example.movieapp.network.Results

class MovieAdapter : ListAdapter<Results, MovieAdapter.MovieViewHolder>(DiffCallBack) {

    var onClick:(Int)->Unit={}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(MovieItemDesingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie=getItem(position)
        holder.bind(movie,onClick)
    }
    class MovieViewHolder(private val binding: MovieItemDesingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(results: Results,onClick:(Int)->Unit={}) {
            binding.movieModel = results
            val preFixUrl="https://image.tmdb.org/t/p/w500"
            Glide.with(binding.imgMovie.context).load(preFixUrl+results.posterPath).into(binding.imgMovie)
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                onClick(results.id)
            }
        }
    }
    companion object DiffCallBack : DiffUtil.ItemCallback<Results>() {
        override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem == newItem
        }
    }
}