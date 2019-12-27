package com.example.nytimesmostpopulararticles.ui.main.article;

import com.androidnetworking.error.ANError;
import com.example.nytimesmostpopulararticles.data.DataManager;
import com.example.nytimesmostpopulararticles.ui.base.BasePresenter;
import com.example.nytimesmostpopulararticles.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ArticlePresenter<V extends ArticleMvpView> extends BasePresenter<V>
        implements ArticleMvpPresenter<V> {

    @Inject
    public ArticlePresenter(DataManager dataManager,
                            SchedulerProvider schedulerProvider,
                            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared(int period) {
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager()
                .getArticlesApiCall(period)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(articleResponse -> {
                    if (articleResponse != null && articleResponse.getArticles() != null) {
                        getMvpView().updateArticle(articleResponse.getArticles());
                    }
                    getMvpView().hideLoading();
                }, throwable -> {
                    if (!isViewAttached()) {
                        return;
                    }

                    getMvpView().hideLoading();

                    // handle the error here
                    if (throwable instanceof ANError) {
                        ANError anError = (ANError) throwable;
                        handleApiError(anError);
                    }
                }));
    }
}
