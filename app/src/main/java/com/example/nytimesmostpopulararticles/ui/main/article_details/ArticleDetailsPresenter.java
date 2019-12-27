package com.example.nytimesmostpopulararticles.ui.main.article_details;

import com.example.nytimesmostpopulararticles.data.DataManager;
import com.example.nytimesmostpopulararticles.ui.base.BasePresenter;
import com.example.nytimesmostpopulararticles.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ArticleDetailsPresenter<V extends ArticleDetailsMvpView> extends BasePresenter<V>
        implements ArticleDetailsMvpPresenter<V> {

    @Inject
    public ArticleDetailsPresenter(DataManager dataManager,
                                   SchedulerProvider schedulerProvider,
                                   CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
