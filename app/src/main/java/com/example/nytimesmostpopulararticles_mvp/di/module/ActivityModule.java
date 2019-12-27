package com.example.nytimesmostpopulararticles_mvp.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nytimesmostpopulararticles_mvp.di.ActivityContext;
import com.example.nytimesmostpopulararticles_mvp.ui.main.MainMvpPresenter;
import com.example.nytimesmostpopulararticles_mvp.ui.main.MainMvpView;
import com.example.nytimesmostpopulararticles_mvp.ui.main.MainPresenter;
import com.example.nytimesmostpopulararticles_mvp.ui.main.article.ArticleAdapter;
import com.example.nytimesmostpopulararticles_mvp.ui.main.article.ArticleMvpPresenter;
import com.example.nytimesmostpopulararticles_mvp.ui.main.article.ArticleMvpView;
import com.example.nytimesmostpopulararticles_mvp.ui.main.article.ArticlePresenter;
import com.example.nytimesmostpopulararticles_mvp.ui.main.article_details.ArticleDetailsMvpPresenter;
import com.example.nytimesmostpopulararticles_mvp.ui.main.article_details.ArticleDetailsMvpView;
import com.example.nytimesmostpopulararticles_mvp.ui.main.article_details.ArticleDetailsPresenter;
import com.example.nytimesmostpopulararticles_mvp.utils.rx.AppSchedulerProvider;
import com.example.nytimesmostpopulararticles_mvp.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    ArticleMvpPresenter<ArticleMvpView> provideArticleMvpPresenter(
            ArticlePresenter<ArticleMvpView> presenter) {
        return presenter;
    }

    @Provides
    ArticleDetailsMvpPresenter<ArticleDetailsMvpView> provideArticleDetailsMvpPresenter(
            ArticleDetailsPresenter<ArticleDetailsMvpView> presenter) {
        return presenter;
    }

    @Provides
    ArticleAdapter provideArticleAdapter() {
        return new ArticleAdapter(new ArrayList<>());
    }
}
