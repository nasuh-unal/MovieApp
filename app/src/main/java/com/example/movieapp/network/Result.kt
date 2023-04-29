package com.example.movieapp.network

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Results(
    var adult: Boolean,
    @SerializedName( "backdrop_path") var backdropPath: String,
    @SerializedName( "genre_ids") var genreIds: ArrayList<Int>,
    var id: Int,
    @SerializedName("original_language") var originalLanguage: String,
    @SerializedName( "original_title") var originalTitle: String,
    var overview: String,
    var popularity: Double,
    @SerializedName( "poster_path") var posterPath: String?,
    @SerializedName( "release_date") var releaseDate: String,
    var title: String,
    var video: Boolean,
    @SerializedName( "vote_average") var voteAverage: Double,
    @SerializedName( "vote_count") var voteCount: Int,
)
