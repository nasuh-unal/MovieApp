package com.example.movieapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

//https://api.themoviedb.org/3/movie/popular?api_key=14775316f5b440bea59bbf6106501e4b&language=en-US&page=1
//https://api.themoviedb.org/3/movie/447277?api_key=14775316f5b440bea59bbf6106501e4b&language=en-US
private const val BASE_URL = "https://api.themoviedb.org/3/movie/"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MovieApiService{
    @GET("popular?api_key=14775316f5b440bea59bbf6106501e4b&language=en-US&page=1")
    suspend fun getMovie():MovieDataModel

    @GET("{movieId}?api_key=14775316f5b440bea59bbf6106501e4b&language=en-US")
    suspend fun getMovieDetails(@Path("movieId") movieId: String):MovieDetailsDataModel
}

object MovieAppApi{
    val retrofitService:MovieApiService by lazy{
        retrofit.create(MovieApiService::class.java)
    }
}


