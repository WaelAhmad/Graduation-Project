package com.example.android.tvguide.view;

/**
 * Created by Wa'el Ahmad on 2/10/2018.
 */
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseInteractor<T>{
  private CompositeDisposable mCompositeDisposable;

  BaseInteractor(){
    mCompositeDisposable = new CompositeDisposable();
  }

  public abstract Observable<T> buildUseCaseObservable(int pageNumber);

  public void execute(DisposableObserver<T> observer, int pageNumber) {
    DisposableObserver<T> disposableObserver =
        buildUseCaseObservable(pageNumber)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(observer);
    mCompositeDisposable.add(disposableObserver);
  }

  public void dispose() {
    if(!mCompositeDisposable.isDisposed()) {
      mCompositeDisposable.dispose();
    }
  }
}
