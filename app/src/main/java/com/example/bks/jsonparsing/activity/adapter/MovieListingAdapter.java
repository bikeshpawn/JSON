package com.example.bks.jsonparsing.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bks.jsonparsing.R;
import com.example.bks.jsonparsing.activity.Respond.MovieListing;
import com.example.bks.jsonparsing.activity.Respond.MovieListingDetail;
import com.example.bks.jsonparsing.activity.Respond.Result;
import com.example.bks.jsonparsing.activity.activity.MainActivity;

import java.util.ArrayList;

/**
 * Created by Bks on 4/10/2017.
 */

public class MovieListingAdapter extends RecyclerView.Adapter<MovieListingAdapter.MovieViewHolder> {

    private ArrayList<Result> movieListingDetailsArrayList;
    private Context context;
    //private MovieItemClickListener movieItemClickListener;


    public MovieListingAdapter(Context context, ArrayList<Result> listview) {
        this.movieListingDetailsArrayList = movieListingDetailsArrayList;
        this.movieListingDetailsArrayList= listview;
        this.context = context;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View LayoutView= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_listing,parent,false);
        MovieViewHolder rvh= new MovieViewHolder(LayoutView);
        return rvh;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.tvMovieTitle.setText(movieListingDetailsArrayList.get(position).getOriginalTitle());
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w185/"+movieListingDetailsArrayList.get(position).getPosterPath())
                .into(holder.ivMovieImage);
        holder.tvmovieReleaseDate.setText(movieListingDetailsArrayList.get(position).getReleaseDate());
        holder.tvMovieRatings.setText("" + movieListingDetailsArrayList.get(position).getVoteAverage());
       /* holder.rlMovieContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (movieItemClickListener != null) {
                    movieItemClickListener.onClick(movieListingDetailsArrayList.get(position));
                }
            }
        });*/
    }


    @Override
    public int getItemCount() {
        return this.movieListingDetailsArrayList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder{
        private TextView tvMovieTitle, tvMovieRatings, tvmovieReleaseDate;
        private ImageView ivMovieImage;
        private RelativeLayout rlMovieContainer;

        public MovieViewHolder(View itemView) {
            super(itemView);

            tvMovieTitle = (TextView) itemView.findViewById(R.id.tv_movie_title);
            tvMovieRatings = (TextView) itemView.findViewById(R.id.tv_movie_ratings);
            tvmovieReleaseDate = (TextView) itemView.findViewById(R.id.tv_movie_release_date);
            ivMovieImage = (ImageView) itemView.findViewById(R.id.iv_movie_poster);
            rlMovieContainer = (RelativeLayout) itemView.findViewById(R.id.rl_movie_container);



        }
    }

    /*public interface movieItemClickListener{
        void onClick(Result result);
    }*/
}
