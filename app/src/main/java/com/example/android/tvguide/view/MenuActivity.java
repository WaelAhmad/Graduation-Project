package com.example.android.tvguide.view;

/**
 * Created by Wa'el Ahmad on 2/10/2018.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.android.tvguide.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_topratedmovies)
    public void showTopRatedMovies(View view) {
        Intent topRatedMoviesIntent = new Intent(MenuActivity.this,
                TopRatedMovieActivity.class);
        startActivity(topRatedMoviesIntent);
    }

    @OnClick(R.id.btn_upcamingmovies)
    public void showUpcomingMovies(View view)
    {
        Intent upcomingMoviesIntent = new Intent(MenuActivity.this,
                UpcomingMoviesActivity.class);
        startActivity(upcomingMoviesIntent);
    }

    @OnClick(R.id.btn_tvshowsontheair)
    public void showTvShowsOnTheAir(View view)
    {
        Intent upcomingMoviesIntent = new Intent(MenuActivity.this,
                TvShowsOnTheAirActivity.class);
        startActivity(upcomingMoviesIntent);
    }

    @OnClick(R.id.btn_search_activity)
    public void searchActivity(View view)
    {
        Intent searchIntent = new Intent(MenuActivity.this,
            SearchActivity.class);
        startActivity(searchIntent);
    }
}
