package com.example.nytimesmostpopulararticles_mvp.data.network;

import com.example.nytimesmostpopulararticles_mvp.data.network.model.ArticlesResponse;

import io.reactivex.Single;

public interface ApiHelper {
    Single<ArticlesResponse> getArticlesApiCall(int period);
}
