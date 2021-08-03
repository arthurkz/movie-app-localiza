package com.my.first.movie.application.services

import com.my.first.movie.application.models.MovieAppResponse
import com.my.first.movie.application.services.MovieApiConstants.DEFAULT_QUERY
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET(value = "movie/popular?$DEFAULT_QUERY")
    fun getMovieList(): Call<MovieAppResponse>

}

object MovieApiConstants{
    private const val API_KEY = "ce8ddcb50e46045a124ebb0d4b1ebf80"
    const val DEFAULT_QUERY = "api_key=$API_KEY"

}