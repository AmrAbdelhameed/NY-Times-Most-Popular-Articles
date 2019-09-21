package com.example.nytimesmostpopulararticles.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.nytimesmostpopulararticles.R;
import com.example.nytimesmostpopulararticles.adapters.ArticlesAdapter;
import com.example.nytimesmostpopulararticles.interfaces.ArticlesContract;
import com.example.nytimesmostpopulararticles.models.ArticlesModel;
import com.example.nytimesmostpopulararticles.models.response.ArticlesResponse;
import com.example.nytimesmostpopulararticles.presenters.ArticlesPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ArticlesContract.View {
    private static int currentPositionOnScroll = 0, oldPositionOnScroll = -1;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.articlesRecyclerView)
    RecyclerView articlesRecyclerView;
    private ArticlesAdapter articlesAdapter;
    private ArticlesContract.Presenter presenter;
    private int period = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new ArticlesPresenter(this, new ArticlesModel(this));
        presenter.requestMostPopularArticles(period);
    }

    @Override
    public void init() {
        ButterKnife.bind(this);
        articlesAdapter = new ArticlesAdapter(this);
        articlesRecyclerView.setAdapter(articlesAdapter);
        initScrollListener();
    }

    @Override
    public void responseMostPopularArticles(ArticlesResponse articlesResponse) {
        if (articlesResponse != null) {
            if (articlesResponse.getResults() != null) {
                articlesAdapter.setResultsBeans(articlesResponse.getResults());
            }
        }
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void errorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void initScrollListener() {
        articlesRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (recyclerView.getLayoutManager() != null) {
                    currentPositionOnScroll = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
                    if (period == 1 || period == 7) {
                        if (currentPositionOnScroll == articlesAdapter.getResultsBeans().size() - 1 && oldPositionOnScroll != currentPositionOnScroll) {
                            oldPositionOnScroll = currentPositionOnScroll;
                            if (period == 1)
                                period = 7;
                            else if (period == 7)
                                period = 30;
                            presenter.requestMostPopularArticles(period);
                        }
                    }
                }
            }
        });
    }
}
