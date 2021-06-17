package com.akshaycp.cinemaparadiseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.akshaycp.cinemaparadiseapp.adapters.RecyclerViewAdapter;
import com.akshaycp.cinemaparadiseapp.classes.Movie;
import com.akshaycp.cinemaparadiseapp.interfaces.RetrofitInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList = findViewById(R.id.recycler_view_movies);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/discover/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        Call<List<Movie>> call = retrofitInterface.getAllMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                    return;
                }

                List<Movie> movies = response.body();

                RecyclerViewAdapter adapter = new RecyclerViewAdapter(movies);
                movieList.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
            }
        });

    }


}