package com.example.nytimesmostpopulararticles.di.component;

import com.example.nytimesmostpopulararticles.di.PerService;
import com.example.nytimesmostpopulararticles.di.module.ServiceModule;
import com.example.nytimesmostpopulararticles.service.SyncService;

import dagger.Component;

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(SyncService service);

}
