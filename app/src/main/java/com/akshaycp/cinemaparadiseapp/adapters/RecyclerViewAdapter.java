package com.akshaycp.cinemaparadiseapp.adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akshaycp.cinemaparadiseapp.R;
import com.akshaycp.cinemaparadiseapp.classes.Movie;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<Movie> movies;

    public RecyclerViewAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerViewHolder holder, int position) {
        holder.bind(movies.get(position));
    }



    @Override
    public int getItemCount() {
        return movies.size();
    }

    public  class RecyclerViewHolder extends RecyclerView.ViewHolder{

        private ImageView movieImage;
        private TextView movieTitle;
        private TextView movieOverview;
        private TextView moviePopularity;

        public RecyclerViewHolder(@NonNull  View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.image_view_poster);
            movieTitle = itemView.findViewById(R.id.text_view_original_title);
            movieOverview = itemView.findViewById(R.id.text_view_overview);
            moviePopularity = itemView.findViewById(R.id.text_view_popularity);
        }

        public void bind(Movie movie){
            movieImage.setImageURI(Uri.parse(movie.image));
            movieTitle.setText(movie.title);
            movieOverview.setText(movie.overview);
            moviePopularity.setText(movie.popularity);
        }
    }
}
