package com.example.nytimesmostpopulararticles_mvp.di.component;

import com.example.nytimesmostpopulararticles_mvp.di.module.ApplicationTestModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {
}
