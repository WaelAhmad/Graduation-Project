package com.example.android.tvguide.view.adapters;

/**
 * Created by Wa'el Ahmad on 2/10/2018.
 */
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.android.tvguide.R;
import com.example.android.tvguide.model.Movie;
import com.example.android.tvguide.view.MovieListFragment;
import com.example.android.tvguide.view.holders.MovieViewHolder;
import com.squareup.picasso.Picasso;
import java.util.List;

public class MovieViewAdapter extends RecyclerView.Adapter<MovieViewHolder> {
  private List<Movie> mMovieList;
  private MovieListFragment mMovieListFragment;

  public MovieViewAdapter(List<Movie> movies) {
    this.mMovieList = movies;
  }

  public void setFragment(MovieListFragment fragment) {
    this.mMovieListFragment = fragment;
  }

  @Override
  public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_row, parent, false);

    return new MovieViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(MovieViewHolder holder, final int position) {
    Movie movie = mMovieList.get(position);
    holder.mTitle.setText(movie.getTitle());
    holder.mRelaseDate.setText(movie.getRelaseDate());
    holder.mRatingScore.setText(String.valueOf(movie.getAverageRating()));
    Picasso.with(mMovieListFragment.getActivity())
        .load("https://image.tmdb.org/t/p/w92" + movie.getPosterPath())
        .into(holder.mPoster);

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Log.d("--->", "onClick " + String.valueOf(position));
        mMovieListFragment.onItemClick(mMovieList.get(position));
      }
    });
  }

  @Override
  public int getItemCount() {
    return mMovieList.size();
  }

  public void dataSetChange(List list) {
    mMovieList.addAll(list);
    notifyDataSetChanged();
  }
}
