package com.example.myapplication.utils;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

public class WorkerThread {
  public static synchronized void doOnWorkerThread(final Runnable runnable, final OnCompleted onCompleted) {
    Completable
        .create(emitter -> {
          runnable.run();
          emitter.onComplete();
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new DisposableCompletableObserver() {

          @Override
          public void onComplete() {
            if (onCompleted != null) {
              onCompleted.onFinish(null);
            }
          }

          @Override
          public void onError(Throwable e) {
            if (onCompleted != null) {
              onCompleted.onError(e.toString());
            }
          }
        });
  }
}