package com.example.nytimesmostpopulararticles.data.network;

import com.example.nytimesmostpopulararticles.data.network.model.ArticlesResponse;

import io.reactivex.Single;

public interface ApiHelper {
    Single<ArticlesResponse> getArticlesApiCall(int period);
}
