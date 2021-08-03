package com.my.first.movie.application

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.my.first.movie.application.models.Movie
import kotlinx.android.synthetic.main.movie_app_item.view.*

class MoviesAppAdapter(
    private val movies: List<Movie>
): RecyclerView.Adapter<MoviesAppAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie: Movie){
            itemView.movie_app_title.text = movie.title
            itemView.movie_app_release_date.text = movie.release
            Glide
                .with(itemView)
                .load(IMAGE_BASE + movie.poster)
                .into(itemView.movie_app_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_app_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies[position])
    }

    override fun getItemCount() = movies.size

}


