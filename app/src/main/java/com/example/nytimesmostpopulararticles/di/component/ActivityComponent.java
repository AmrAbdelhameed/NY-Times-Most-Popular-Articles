package com.example.nytimesmostpopulararticles.di.component;

import com.example.nytimesmostpopulararticles.di.PerActivity;
import com.example.nytimesmostpopulararticles.di.module.ActivityModule;
import com.example.nytimesmostpopulararticles.ui.main.MainActivity;
import com.example.nytimesmostpopulararticles.ui.main.article.ArticleFragment;
import com.example.nytimesmostpopulararticles.ui.main.article_details.ArticleDetailsFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);

    void inject(ArticleFragment fragment);

    void inject(ArticleDetailsFragment fragment);
}
