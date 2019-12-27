package com.example.nytimesmostpopulararticles.di.module;

import android.app.Application;
import android.content.Context;

import com.example.nytimesmostpopulararticles.BuildConfig;
import com.example.nytimesmostpopulararticles.data.AppDataManager;
import com.example.nytimesmostpopulararticles.data.DataManager;
import com.example.nytimesmostpopulararticles.data.db.AppDbHelper;
import com.example.nytimesmostpopulararticles.data.db.DbHelper;
import com.example.nytimesmostpopulararticles.data.network.ApiHelper;
import com.example.nytimesmostpopulararticles.data.network.AppApiHelper;
import com.example.nytimesmostpopulararticles.data.prefs.AppPreferencesHelper;
import com.example.nytimesmostpopulararticles.data.prefs.PreferencesHelper;
import com.example.nytimesmostpopulararticles.di.ApiInfo;
import com.example.nytimesmostpopulararticles.di.ApplicationContext;
import com.example.nytimesmostpopulararticles.di.DatabaseInfo;
import com.example.nytimesmostpopulararticles.di.PreferenceInfo;
import com.example.nytimesmostpopulararticles.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
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
