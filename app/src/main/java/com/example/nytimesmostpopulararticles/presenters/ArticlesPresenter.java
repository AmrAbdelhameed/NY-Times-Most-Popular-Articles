package com.example.nytimesmostpopulararticles.presenters;

import com.example.nytimesmostpopulararticles.interfaces.ArticlesContract;
import com.example.nytimesmostpopulararticles.models.response.ArticlesResponse;
import com.example.nytimesmostpopulararticles.network.MyCallbackResponse;

public class ArticlesPresenter implements ArticlesContract.Presenter {
    private ArticlesContract.View view;
    private ArticlesContract.Model model;

    public ArticlesPresenter(ArticlesContract.View view, ArticlesContract.Model model) {
        this.view = view;
        this.model = model;
        if (view != null) {
            view.init();
        }
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void requestMostPopularArticles(int period) {
        if (view != null) {
            view.showProgress();
            model.getMostPopularArticles(period, new MyCallbackResponse<ArticlesResponse>() {
                @Override
                public void onSuccess(ArticlesResponse response) {
                    if (view != null) {
                        view.responseMostPopularArticles(response);
                        view.hideProgress();
                    }
                }

                @Override
                public void onFailed(String message) {
                    if (view != null) {
                        view.errorMessage(message);
                        view.hideProgress();
                    }
                }
            });
        }
    }
}
