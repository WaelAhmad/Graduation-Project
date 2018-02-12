package com.example.android.tvguide.view.adapters;

/**
 * Created by Wa'el Ahmad on 2/10/2018.
 */
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.android.tvguide.R;
import com.example.android.tvguide.model.Movie;
import com.example.android.tvguide.view.SearchFragment;
import com.squareup.picasso.Picasso;
import java.util.List;

public class SearchAdapter extends Adapter<SearchAdapter.SearchViewHolder> {
  private List<Movie> mMovieList;
  private SearchFragment mSearchFragment;

  public void setFragment(SearchFragment fragment) {
    this.mSearchFragment = fragment;
  }

  @Override
  public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_row, parent, false);

    return new SearchViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(SearchViewHolder holder, int position) {
    Movie movie = mMovieList.get(position);
    holder.mTitle.setText(movie.getTitle());
    holder.mRelaseDate.setText(movie.getRelaseDate());
    holder.mRatingScore.setText(String.valueOf(movie.getAverageRating()));
    Picasso.with(mSearchFragment.getActivity())
        .load("https://image.tmdb.org/t/p/w92" + movie.getPosterPath()).into(holder.mPoster);
  }

  public void dataSetChange(List<Movie> list)
  {
    this.mMovieList = list;
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return mMovieList == null ? 0 : mMovieList.size();
  }

  public static class SearchViewHolder extends RecyclerView.ViewHolder
  {
    public final TextView mTitle;
    public final TextView mRelaseDate;
    public final TextView mRatingScore;
    public final ImageView mPoster;

    public SearchViewHolder(View itemView) {
      super(itemView);

      this.mTitle = (TextView) itemView.findViewById(R.id.title);
      this.mRelaseDate = (TextView) itemView.findViewById(R.id.relase_date);
      this.mRatingScore = (TextView) itemView.findViewById(R.id.rating_score);
      this.mPoster = (ImageView) itemView.findViewById(R.id.movie_poster);
    }
  }

}
