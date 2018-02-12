package com.example.android.tvguide.view.adapters;

/**
 * Created by Wa'el Ahmad on 2/10/2018.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.android.tvguide.R;
import com.example.android.tvguide.model.TvShow;
import com.example.android.tvguide.view.TvShowsListFragment;
import com.example.android.tvguide.view.holders.TvShowViewHolder;
import com.squareup.picasso.Picasso;
import java.util.List;

public class TvShowViewAdapter extends RecyclerView.Adapter<TvShowViewHolder> {
  private List<TvShow> mTvShowList;
  private TvShowsListFragment mTvShowListFragment;

  public TvShowViewAdapter(List<TvShow> tvShowList) {
    this.mTvShowList = tvShowList;
  }

  public void setFragment(TvShowsListFragment fragment) {
    this.mTvShowListFragment = fragment;
  }

  @Override
  public TvShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_row, parent, false);

    return new TvShowViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(TvShowViewHolder holder, final int position) {
    TvShow tvShow = mTvShowList.get(position);
    holder.mName.setText(tvShow.getName());
    holder.mRelaseDate.setText(tvShow.getFirstAirDate());
    holder.mRatingScore.setText(String.valueOf(tvShow.getAverageRating()));
    Picasso.with(mTvShowListFragment.getActivity())
        .load("https://image.tmdb.org/t/p/w92" + tvShow.getPosterPath()).into(holder.mPoster);

    // implementation later
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("--->", "onClick " + String.valueOf(position));
//                mMovieListFragment.onItemClick(position);
//            }
//        });
  }

  public void dataSetChange(List list) {
      mTvShowList.addAll(list);
      notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return mTvShowList.size();
  }
}
