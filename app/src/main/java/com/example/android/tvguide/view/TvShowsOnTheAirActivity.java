package com.example.android.tvguide.view;

/**
 * Created by Wa'el Ahmad on 2/10/2018.
 */
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.example.android.tvguide.R;
import com.example.android.tvguide.presenter.TvShowsPresenter;

public class TvShowsOnTheAirActivity extends FragmentActivity {
  private TvShowsListFragment mTvShowListFragment;
  private TvShowsPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_serieslist);

    mTvShowListFragment = new TvShowsListFragment();

    FragmentManager fragmentManager =
        getFragmentManager();
    FragmentTransaction fragmentTransaction =
        fragmentManager.beginTransaction();
    fragmentTransaction.add(R.id.fragment_holder_series, mTvShowListFragment);
    fragmentTransaction.commit();

    presenter = new TvShowsPresenter(mTvShowListFragment);
    mTvShowListFragment.initPresenter(presenter);
  }

  @Override
  public void onDestroy() {
    presenter.disposeResource();
    super.onDestroy();
  }
}
