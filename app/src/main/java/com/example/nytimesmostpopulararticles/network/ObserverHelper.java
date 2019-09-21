package com.example.nytimesmostpopulararticles.network;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class ObserverHelper<T> implements Observer<T> {
    @Override
    public void onComplete() {
    }

    @Override
    public void onSubscribe(Disposable d) {
    }
}
