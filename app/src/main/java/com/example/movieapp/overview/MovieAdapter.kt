package com.example.movieapp.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.MovieItemDesingBinding
import com.example.movieapp.network.MovieDataModel
import com.example.movieapp.network.Results

class MovieAdapter : ListAdapter<Results, MovieAdapter.MovieViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(MovieItemDesingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie=getItem(position)
        holder.bind(movie)
    }
    class MovieViewHolder(private val binding: MovieItemDesingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(results: Results) {
            binding.movieModel = results
            binding.executePendingBindings()
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