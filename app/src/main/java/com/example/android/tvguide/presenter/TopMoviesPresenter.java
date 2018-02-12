package com.example.android.tvguide.presenter;

/**
 * Created by Wa'el Ahmad on 2/10/2018.
 */
import com.example.android.tvguide.model.MoviesResponse;
import com.example.android.tvguide.view.IListView;
import com.example.android.tvguide.view.TopMovieInteractor;
import io.reactivex.observers.DisposableObserver;

public class TopMoviesPresenter implements IPresenter {
    private TopMovieInteractor mInteractor;
    private IListView mListView;
    private int page = 1;

    public TopMoviesPresenter(IListView listView) {
        this.mListView = listView;
    }

    @Override
    public void loadData() {

        mListView.showLoadingIndicator();
        mInteractor = new TopMovieInteractor();
        mInteractor.execute(new TopMoviesObserver(), page);
    }

    @Override
    public void disposeResource() {
        if(mInteractor != null) {
            mInteractor.dispose();
        }
    }

    private final class TopMoviesObserver extends DisposableObserver<MoviesResponse> {

        @Override
        public void onNext(MoviesResponse value) {
            TopMoviesPresenter.this.mListView.showData(value.getResults());
        }

        @Override
        public void onError(Throwable e) {
            TopMoviesPresenter.this.mListView.hideLoadingIndicator();
        }

        @Override
        public void onComplete() {
            TopMoviesPresenter.this.mListView.hideLoadingIndicator();
        }
    }
}
