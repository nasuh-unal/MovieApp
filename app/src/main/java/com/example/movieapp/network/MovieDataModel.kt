package com.example.movieapp.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

data class MovieDataModel(
     @SerializedName("page"          )var page         : Int,
     @SerializedName("results"       )var results     : List<Results>,
     @SerializedName("total_pages"   ) var totalPages   : Int,
     @SerializedName("total_results" ) var totalResults : Int,
)
