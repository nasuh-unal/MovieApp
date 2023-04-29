package com.example.movieapp.network

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//@JsonClass(generateAdapter = true)
data class MovieDataModel(
   /* @Json(name="page"          ) var pagee         : Int  ,
    @Json(name="results"       ) var resultss     : List<Results> ,
    @Json(name="total_pages"   ) var totalPagess   : Int,
    @Json(name="total_results" ) var totalResultss : Int,*/
     var page         : Int,
     var results     : List<Results>,
     @SerializedName("total_pages"   ) var totalPages   : Int,
     @SerializedName("total_results" ) var totalResults : Int,
)
