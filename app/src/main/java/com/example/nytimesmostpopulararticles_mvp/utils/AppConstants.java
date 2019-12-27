package com.example.nytimesmostpopulararticles_mvp.utils;

import com.example.nytimesmostpopulararticles_mvp.BuildConfig;

public final class AppConstants {

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String DB_NAME = BuildConfig.APPLICATION_ID + ".db";

    public static final String PREF_NAME = BuildConfig.APPLICATION_ID + "_pref";

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    public static final String ARTICLE = "article";

    public static final String ARTICLES = "articles";

    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
