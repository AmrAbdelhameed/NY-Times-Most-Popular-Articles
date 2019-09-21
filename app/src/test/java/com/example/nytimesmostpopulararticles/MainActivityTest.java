package com.example.nytimesmostpopulararticles;

import com.example.nytimesmostpopulararticles.interfaces.ArticlesContract;
import com.example.nytimesmostpopulararticles.models.ArticlesModel;
import com.example.nytimesmostpopulararticles.models.response.ArticlesResponse;
import com.example.nytimesmostpopulararticles.network.MyCallbackResponse;
import com.example.nytimesmostpopulararticles.presenters.ArticlesPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

public class MainActivityTest {
    private ArticlesContract.Presenter presenter;

    @Mock
    private ArticlesModel articlesModel;

    @Mock
    private ArticlesContract.View view;

    @Mock
    private ArticlesResponse articlesResponse;

    @Captor
    private ArgumentCaptor<MyCallbackResponse<ArticlesResponse>> loginListenerArgumentCaptor;

    @Before
    public void setUpArticlesPresenter() {
        MockitoAnnotations.initMocks(this);
        presenter = new ArticlesPresenter(view, articlesModel);
    }

    @Test
    public void getArticles() {
        int period = 1;
        presenter.requestMostPopularArticles(period);
        verify(articlesModel).getMostPopularArticles(eq(period), loginListenerArgumentCaptor.capture());

        loginListenerArgumentCaptor.getValue().onSuccess(articlesResponse);
        verify(view).responseMostPopularArticles(articlesResponse);

        loginListenerArgumentCaptor.getValue().onFailed("Sorry, Something went wrong");
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(view).errorMessage(argumentCaptor.capture());

        assertEquals("Sorry, Something went wrong", argumentCaptor.getValue());
    }
}
