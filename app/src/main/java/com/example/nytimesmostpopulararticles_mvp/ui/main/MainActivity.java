package com.example.nytimesmostpopulararticles_mvp.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.nytimesmostpopulararticles_mvp.R;
import com.example.nytimesmostpopulararticles_mvp.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {
    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUp();
    }

    @Override
    protected void setUp() {
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
