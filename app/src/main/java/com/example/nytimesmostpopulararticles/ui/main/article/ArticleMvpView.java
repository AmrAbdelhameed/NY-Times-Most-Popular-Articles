package com.example.nytimesmostpopulararticles.ui.main.article;

import com.example.nytimesmostpopulararticles.data.network.model.ArticlesResponse;
import com.example.nytimesmostpopulararticles.ui.base.MvpView;

import java.util.List;

public interface ArticleMvpView extends MvpView {

    void updateArticle(List<ArticlesResponse.Article> articleList);
}
