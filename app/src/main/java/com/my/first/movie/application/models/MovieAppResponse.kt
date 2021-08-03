package com.my.first.movie.application.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieAppResponse(
    @SerializedName("results")
    val movieList: List<Movie>

): Parcelable {
    constructor(): this(mutableListOf())
}