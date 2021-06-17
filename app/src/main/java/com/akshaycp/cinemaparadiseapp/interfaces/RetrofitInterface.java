package com.akshaycp.cinemaparadiseapp.interfaces;

import com.akshaycp.cinemaparadiseapp.classes.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    @GET("/movie?api_key=9555e26950e57c80d2eeff35141f574d&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate")
    Call<List<Movie>> getAllMovies();
}
