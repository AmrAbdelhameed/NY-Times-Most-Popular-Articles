package com.example.nytimesmostpopulararticles_mvp.di.component;

import com.example.nytimesmostpopulararticles_mvp.di.PerActivity;
import com.example.nytimesmostpopulararticles_mvp.di.module.ActivityModule;
import com.example.nytimesmostpopulararticles_mvp.ui.main.MainActivity;
import com.example.nytimesmostpopulararticles_mvp.ui.main.article.ArticleFragment;
import com.example.nytimesmostpopulararticles_mvp.ui.main.article_details.ArticleDetailsFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);

    void inject(ArticleFragment fragment);

    void inject(ArticleDetailsFragment fragment);
}
