package com.my.first.movie.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.my.first.movie.application.models.MovieAppResponse
import com.my.first.movie.application.models.Movie
import com.my.first.movie.application.services.MovieApiInterface
import com.my.first.movie.application.services.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movie_app_rv.layoutManager = LinearLayoutManager(this)
        movie_app_rv.setHasFixedSize(true)
        getMovieData { movies: List<Movie> ->
            movie_app_rv.adapter = MoviesAppAdapter(movies)
        }
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val  apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieAppResponse> {

            override fun onResponse(call: Call<MovieAppResponse>, response: Response<MovieAppResponse>) {
                return callback(response.body()!!.movieList)
            }

            override fun onFailure(call: Call<MovieAppResponse>, t: Throwable) {
            }

        })
    }
}