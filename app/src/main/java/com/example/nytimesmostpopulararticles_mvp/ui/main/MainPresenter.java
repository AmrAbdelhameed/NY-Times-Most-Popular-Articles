package com.example.nytimesmostpopulararticles_mvp.ui.main;

import com.example.nytimesmostpopulararticles_mvp.data.DataManager;
import com.example.nytimesmostpopulararticles_mvp.ui.base.BasePresenter;
import com.example.nytimesmostpopulararticles_mvp.ui.base.MvpView;
import com.example.nytimesmostpopulararticles_mvp.utils.rx.SchedulerProvider;

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
