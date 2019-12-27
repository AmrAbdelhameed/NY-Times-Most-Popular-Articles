package com.example.nytimesmostpopulararticles_mvp.di.component;

import com.example.nytimesmostpopulararticles_mvp.di.PerService;
import com.example.nytimesmostpopulararticles_mvp.di.module.ServiceModule;
import com.example.nytimesmostpopulararticles_mvp.service.SyncService;

import dagger.Component;

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(SyncService service);

}
