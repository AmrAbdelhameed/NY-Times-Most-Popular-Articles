package com.example.nytimesmostpopulararticles.ui.main.article;

import com.example.nytimesmostpopulararticles.ui.base.MvpPresenter;

public interface ArticleMvpPresenter<V extends ArticleMvpView>
        extends MvpPresenter<V> {

    void onViewPrepared(int period);
}


