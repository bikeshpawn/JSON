package com.example.bks.jsonparsing.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.example.bks.jsonparsing.BuildConfig;
import com.example.bks.jsonparsing.R;
import com.example.bks.jsonparsing.activity.Respond.MovieListing;
import com.example.bks.jsonparsing.activity.Respond.MovieListingDetail;
import com.example.bks.jsonparsing.activity.Respond.Result;
import com.example.bks.jsonparsing.activity.adapter.MovieListingAdapter;
import com.example.bks.jsonparsing.activity.rest.RetrofitManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ArrayList<Result> upcomingMovieList= new ArrayList<>();
    private MovieListingAdapter rcAdapter;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= (RecyclerView)findViewById(R.id.rv_movie_listing);


        //StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

       /* GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);*/

       LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);


       recyclerView.setLayoutManager(linearLayoutManager);

        getMovieListing();
        rcAdapter = new MovieListingAdapter(MainActivity.this, upcomingMovieList);
        recyclerView.setAdapter(rcAdapter);
    }


    private void getMovieListing(){

        RetrofitManager.getInstance().getUpcomingMovieList(BuildConfig.TMDBMOVIEAPIKEY , new Callback<MovieListing>(){ //BuildConfig.TMDBMOVIEAPIKEY

            @Override
            public void onResponse(Call<MovieListing> call, Response<MovieListing> response) {

                if (response.code() == 200){
                    updateMovies(response);
                }
                else{
                    Log.i(TAG, "onResponse: " + response);
                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MovieListing> call, Throwable t) {
                Log.i(TAG, "onFailure: "+ t.getLocalizedMessage());
            }
        });
    }

    //update movie list when response is success
    private void updateMovies(Response<MovieListing> response){
        upcomingMovieList.addAll(response.body().getResults());
        rcAdapter.notifyDataSetChanged();
       /* rcAdapter.setClickListener(new MovieListingAdapter.MovieItemClickListener(){
            @Override
            public void onClick(Result result) {
                startActivity(DetailActivity.getLaunchIntent(MainActivity.this, result));
            }
        });*/

        //  below line defined inside DetailActivity
//        mListAdapter.setClickListener(new MovieListingAdapter.MovieItemClickListener(){
//            @Override
//            public void onClick(Result result) {
//                Intent startDetailActivity = new Intent(MainActivity.this, DetailActivity.class);
//                startDetailActivity.putExtra("Movie_Detail", result);
//                startActivity(startDetailActivity);
//            }
//        });
    }

   /* public interface MovieItemClickListener {
        void onClick(Result result);
    }*/
}
