package com.example.android.tvguide.view;

/**
 * Created by Wa'el Ahmad on 2/10/2018.
 */
import com.example.android.tvguide.model.Movie;
import java.util.List;

public interface IListView {
  void onItemClick(Movie movie);
  void showData(List list);
  void showLoadingIndicator();
  void hideLoadingIndicator();
}
