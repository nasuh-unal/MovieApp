package com.example.movieapp

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.centerCropTransform
import com.example.movieapp.network.MovieDataModel
import com.example.movieapp.network.Results
import com.example.movieapp.overview.MovieAdapter
import com.example.movieapp.util.Constants

/*
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView:RecyclerView,data:List<Results>?){
    val adapter=recyclerView.adapter as MovieAdapter
    adapter.submitList(data)
}*/
/*
@BindingAdapter("imageUrl")
fun bindImage(imageView:ImageView,imageurl:String?){
    imageurl?.let {
        Glide.with(imageView.context).load(imageurl).into(imageView)
    }
}*/
fun ImageView.loadImage(path:String?){
    Glide.with(this.context).load(Constants.IMAGE_BASE_URL+path).apply(centerCropTransform().error(R.drawable.ic_error)).into(this)
}
