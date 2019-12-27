package com.example.nytimesmostpopulararticles.ui.main;

import com.example.nytimesmostpopulararticles.data.DataManager;
import com.example.nytimesmostpopulararticles.ui.base.BasePresenter;
import com.example.nytimesmostpopulararticles.ui.base.MvpView;
import com.example.nytimesmostpopulararticles.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter<V extends MvpView> extends BasePresenter<V> implements
        MainMvpPresenter<V> {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
