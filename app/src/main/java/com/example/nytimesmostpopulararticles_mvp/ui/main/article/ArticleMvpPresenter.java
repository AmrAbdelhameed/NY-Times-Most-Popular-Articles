package com.example.nytimesmostpopulararticles_mvp.ui.main.article;

import com.example.nytimesmostpopulararticles_mvp.ui.base.MvpPresenter;

public interface ArticleMvpPresenter<V extends ArticleMvpView>
        extends MvpPresenter<V> {

    void onViewPrepared(int period);
}


