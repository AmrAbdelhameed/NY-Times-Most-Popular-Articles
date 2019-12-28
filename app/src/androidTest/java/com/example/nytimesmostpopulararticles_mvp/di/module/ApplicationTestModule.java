package com.example.nytimesmostpopulararticles_mvp.di.module;

import android.app.Application;
import android.content.Context;

import com.example.nytimesmostpopulararticles_mvp.BuildConfig;
import com.example.nytimesmostpopulararticles_mvp.data.AppDataManager;
import com.example.nytimesmostpopulararticles_mvp.data.DataManager;
import com.example.nytimesmostpopulararticles_mvp.data.db.AppDbHelper;
import com.example.nytimesmostpopulararticles_mvp.data.db.DbHelper;
import com.example.nytimesmostpopulararticles_mvp.data.network.ApiHelper;
import com.example.nytimesmostpopulararticles_mvp.data.network.AppApiHelper;
import com.example.nytimesmostpopulararticles_mvp.data.prefs.AppPreferencesHelper;
import com.example.nytimesmostpopulararticles_mvp.data.prefs.PreferencesHelper;
import com.example.nytimesmostpopulararticles_mvp.di.ApiInfo;
import com.example.nytimesmostpopulararticles_mvp.di.ApplicationContext;
import com.example.nytimesmostpopulararticles_mvp.di.DatabaseInfo;
import com.example.nytimesmostpopulararticles_mvp.di.PreferenceInfo;
import com.example.nytimesmostpopulararticles_mvp.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationTestModule {

    private final Application mApplication;

    public ApplicationTestModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    // TODO : Mock all below for UI testing

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }
}
