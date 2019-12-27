package com.example.nytimesmostpopulararticles_mvp;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor.Level;
import com.example.nytimesmostpopulararticles_mvp.data.DataManager;
import com.example.nytimesmostpopulararticles_mvp.di.component.ApplicationComponent;
import com.example.nytimesmostpopulararticles_mvp.di.component.DaggerApplicationComponent;
import com.example.nytimesmostpopulararticles_mvp.di.module.ApplicationModule;

import javax.inject.Inject;

public class CustomApplication extends Application {

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(Level.BODY);
        }
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
