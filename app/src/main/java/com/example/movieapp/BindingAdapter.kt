package com.example.movieapp

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.network.MovieDataModel
import com.example.movieapp.network.Results
import com.example.movieapp.overview.MovieAdapter
/*
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView:RecyclerView,data:List<Results>?){
    val adapter=recyclerView.adapter as MovieAdapter
    adapter.submitList(data)
}*/

@BindingAdapter("imageUrl")
fun bindImage(imageView:ImageView,imageurl:String?){
    imageurl?.let {
        Glide.with(imageView.context).load(imageurl).into(imageView)
    }
}