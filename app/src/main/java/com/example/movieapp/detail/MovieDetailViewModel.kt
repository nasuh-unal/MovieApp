package com.example.movieapp.detail

import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.viewModelScope
import com.example.movieapp.network.*
import com.example.movieapp.util.Constants
import kotlinx.coroutines.launch

class MovieDetailViewModel(id: Int) : ViewModel() {
    private val _moviesDetail = MutableLiveData<MovieDetailsDataModel?>()
    val moviesDetail: LiveData<MovieDetailsDataModel?> get() = _moviesDetail
    var _id = id

    init {
        getMovieDetail(_id)
    }

    private fun getMovieDetail(movieIdd: Int) {
        Log.v("aa",movieIdd.toString())
        viewModelScope.launch {
            try {
                _moviesDetail.value = MovieAppApi.retrofitService.getMovieDetails(movieId=movieIdd.toString())
                Log.v("mesaj", _moviesDetail.value.toString())
            } catch (e: Exception) {
                _moviesDetail.value = null
                Log.v("mesaj", e.message.toString())
            }
        }
    }
}




