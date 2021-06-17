package com.akshaycp.cinemaparadiseapp.classes;

import com.google.gson.annotations.SerializedName;

public class Movie {

  @SerializedName("original_title")
  public  String title;

    @SerializedName("overview")
  public  String overview;

    @SerializedName("popularity")
  public  String popularity;

    @SerializedName("poster_path")
  public  String image;

    public Movie(String title, String overview, String popularity, String image) {
        this.title = title;
        this.overview = overview;
        this.popularity = popularity;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
