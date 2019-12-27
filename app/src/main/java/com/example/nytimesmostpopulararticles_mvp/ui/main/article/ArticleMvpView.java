package com.example.nytimesmostpopulararticles_mvp.ui.main.article;

import com.example.nytimesmostpopulararticles_mvp.data.network.model.ArticlesResponse;
import com.example.nytimesmostpopulararticles_mvp.ui.base.MvpView;

import java.util.List;

public interface ArticleMvpView extends MvpView {

    void updateArticle(List<ArticlesResponse.Article> articleList);
}
