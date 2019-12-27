package com.example.nytimesmostpopulararticles.data;


import android.content.Context;

import com.example.nytimesmostpopulararticles.data.db.DbHelper;
import com.example.nytimesmostpopulararticles.data.network.ApiHelper;
import com.example.nytimesmostpopulararticles.data.network.model.ArticlesResponse;
import com.example.nytimesmostpopulararticles.data.prefs.PreferencesHelper;
import com.example.nytimesmostpopulararticles.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public Single<ArticlesResponse> getArticlesApiCall(int period) {
        return mApiHelper.getArticlesApiCall(period);
    }
}
