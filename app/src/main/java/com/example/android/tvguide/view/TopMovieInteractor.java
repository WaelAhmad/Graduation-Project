package com.example.android.tvguide.view;

/**
 * Created by Wa'el Ahmad on 2/10/2018.
 */
import com.example.android.tvguide.model.DataManager;
import com.example.android.tvguide.model.MoviesResponse;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TopMovieInteractor extends BaseInteractor<MoviesResponse> {
  public TopMovieInteractor() {
    super();
  }

  @Override
  public Observable<MoviesResponse> buildUseCaseObservable(int pageNumber) {
    return DataManager.fetchTopRatedMoviesData(pageNumber)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }
}
