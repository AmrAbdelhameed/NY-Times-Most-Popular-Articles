package com.example.nytimesmostpopulararticles.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.nytimesmostpopulararticles.R;
import com.example.nytimesmostpopulararticles.ui.base.BaseActivity;
import com.example.nytimesmostpopulararticles.ui.main.article.ArticleFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {
    private static final String CURRENT_FRAGMENT_TAG = "current_fragment";
    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);

        if (savedInstanceState == null)
            setUp();
        else
            handleOnConfigurationChanged();
    }

    @Override
    protected void setUp() {
        replaceCurrentFragment(ArticleFragment.newInstance(), false);
    }

    private void handleOnConfigurationChanged() {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(CURRENT_FRAGMENT_TAG);
        replaceCurrentFragment(fragment, false);
    }

    public void replaceCurrentFragment(Bundle data, Fragment fragment) {
        fragment.setArguments(data);
        replaceCurrentFragment(fragment, true);
    }

    private void replaceCurrentFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.screenContainer, fragment, CURRENT_FRAGMENT_TAG);
        if (addToBackStack)
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
