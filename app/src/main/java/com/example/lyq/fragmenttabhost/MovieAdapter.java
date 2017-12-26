package com.example.lyq.fragmenttabhost;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lyq on 2017/10/18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Movie> mMovieList;

    static class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView movieLeftImage;
        private final TextView movieLeftName;
        private final ImageView movieRightImage;
        private final TextView movieRightName;

        public ViewHolder(View view){
            super(view);
            movieLeftImage = (ImageView) view.findViewById(R.id.movie_left_image);
            movieLeftName = (TextView) view.findViewById(R.id.movie_left_name);
            movieRightImage = (ImageView) view.findViewById(R.id.movie_right_image);
            movieRightName = (TextView) view.findViewById(R.id.movie_right_name);
        }
    }

    public MovieAdapter(List<Movie> movieList){
        mMovieList = movieList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = mMovieList.get(position);
        holder.movieLeftImage.setImageResource(movie.getLeftImage());
        holder.movieLeftName.setText(movie.getLeftName());
        holder.movieRightImage.setImageResource(movie.getRightImage());
        holder.movieRightName.setText(movie.getRightName());
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }
}
