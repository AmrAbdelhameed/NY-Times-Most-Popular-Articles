package com.example.nytimesmostpopulararticles.interfaces;

import com.example.nytimesmostpopulararticles.models.response.ArticlesResponse;
import com.example.nytimesmostpopulararticles.network.MyCallbackResponse;

public interface ArticlesContract {
    interface Presenter extends BasePresenter {
        void requestMostPopularArticles(int period);
    }

    interface View extends BaseView {
        void initScrollListener();

        void responseMostPopularArticles(ArticlesResponse articlesResponse);
    }

    interface Model {
        void getMostPopularArticles(int period, MyCallbackResponse<ArticlesResponse> articleMyCallbackResponse);
    }
}
