package com.example.nytimesmostpopulararticles_mvp.data.network;

import com.example.nytimesmostpopulararticles_mvp.BuildConfig;

public final class ApiEndPoint {

    public static final String ENDPOINT_ARTICLES = BuildConfig.BASE_URL + "/v2/viewed/{period}.json";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }
}
