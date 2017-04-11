package com.example.bks.jsonparsing.activity.rest;

import com.example.bks.jsonparsing.activity.Respond.MovieListing;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Bks on 4/10/2017.
 */

interface MovieListingService {
    @GET("upcoming")
    Call<MovieListing> getUpcomingMovies(@Query("api_key") String apiKey);  //Query is url manipulators , Path, body, full, part
}
