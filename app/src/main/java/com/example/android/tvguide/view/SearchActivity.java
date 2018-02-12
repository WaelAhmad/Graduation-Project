package com.example.android.tvguide.view;

/**
 * Created by Wa'el Ahmad on 2/10/2018.
 */
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.example.android.tvguide.R;
import com.example.android.tvguide.presenter.SearchPresenter;

public class SearchActivity extends Activity {
  private SearchFragment mSearchFragment;
  public SearchPresenter mSearchPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);

    mSearchFragment = new SearchFragment();

    FragmentManager fragmentManager =
        getFragmentManager();
    FragmentTransaction fragmentTransaction =
        fragmentManager.beginTransaction();
    fragmentTransaction.add(R.id.fragment_holder_search, mSearchFragment);
    fragmentTransaction.commit();

    mSearchPresenter = new SearchPresenter(mSearchFragment);
    mSearchFragment.initPresenter(mSearchPresenter);
  }
}
