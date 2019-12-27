package com.example.nytimesmostpopulararticles.di.component;

import android.app.Application;
import android.content.Context;

import com.example.nytimesmostpopulararticles.CustomApplication;
import com.example.nytimesmostpopulararticles.data.DataManager;
import com.example.nytimesmostpopulararticles.di.ApplicationContext;
import com.example.nytimesmostpopulararticles.di.module.ApplicationModule;
import com.example.nytimesmostpopulararticles.service.SyncService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(CustomApplication app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}