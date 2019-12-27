package com.example.nytimesmostpopulararticles_mvp.data;


import android.content.Context;

import com.example.nytimesmostpopulararticles_mvp.data.db.DbHelper;
import com.example.nytimesmostpopulararticles_mvp.data.network.ApiHelper;
import com.example.nytimesmostpopulararticles_mvp.data.network.model.ArticlesResponse;
import com.example.nytimesmostpopulararticles_mvp.data.prefs.PreferencesHelper;
import com.example.nytimesmostpopulararticles_mvp.di.ApplicationContext;

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
