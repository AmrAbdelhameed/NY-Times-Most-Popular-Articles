package com.example.nytimesmostpopulararticles_mvp.di.component;

import android.app.Application;
import android.content.Context;

import com.example.nytimesmostpopulararticles_mvp.CustomApplication;
import com.example.nytimesmostpopulararticles_mvp.data.DataManager;
import com.example.nytimesmostpopulararticles_mvp.di.ApplicationContext;
import com.example.nytimesmostpopulararticles_mvp.di.module.ApplicationModule;
import com.example.nytimesmostpopulararticles_mvp.service.SyncService;

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