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

enum class MovieApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel : ViewModel() {

    /*private val _status = MutableLiveData<MovieApiStatus>()
    val status: LiveData<MovieApiStatus> get() = _status*/

    private val _movies = MutableLiveData<List<Results>>()
    val movies: LiveData<List<Results>> get() = _movies

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            //_status.value=MovieApiStatus.LOADING
            try {
                _movies.value=MovieAppApi.retrofitService.getMovie().results
                Log.v("mesaj",_movies.value.toString())
                //_status.value=MovieApiStatus.DONE
            }catch (e:Exception){
                //_status.value=MovieApiStatus.ERROR
                _movies.value=ArrayList()
                Log.v("mesaj",e.message.toString())
            }
        }
    }
}