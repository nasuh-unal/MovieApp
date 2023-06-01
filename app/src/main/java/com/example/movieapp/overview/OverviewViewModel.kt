package com.example.movieapp.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.network.MovieAppApi
import com.example.movieapp.network.Results
import kotlinx.coroutines.launch
import java.lang.Exception

class OverviewViewModel : ViewModel() {

    private val _movies = MutableLiveData<List<Results>>()
    val movies: LiveData<List<Results>> get() = _movies

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            try {
                _movies.value=MovieAppApi.retrofitService.getMovie().results
            }catch (e:Exception){
                _movies.value=ArrayList()
            }
        }
    }
}