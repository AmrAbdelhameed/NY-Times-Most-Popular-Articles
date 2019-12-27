package com.example.nytimesmostpopulararticles_mvp.ui.main.article_details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.nytimesmostpopulararticles_mvp.R;
import com.example.nytimesmostpopulararticles_mvp.data.network.model.ArticlesResponse;
import com.example.nytimesmostpopulararticles_mvp.di.component.ActivityComponent;
import com.example.nytimesmostpopulararticles_mvp.ui.base.BaseFragment;
import com.example.nytimesmostpopulararticles_mvp.ui.main.MainActivity;
import com.example.nytimesmostpopulararticles_mvp.utils.AppConstants;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleDetailsFragment extends BaseFragment implements
        ArticleDetailsMvpView {

    @Inject
    ArticleDetailsMvpPresenter<ArticleDetailsMvpView> mPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.articleImg)
    ImageView articleImg;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.byline)
    TextView byline;
    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.published_date)
    TextView published_date;
    @BindView(R.id.url)
    TextView url;

    public ArticleDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_article_details, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);

            if (getActivity() != null) {
                ((MainActivity) getActivity()).setSupportActionBar(toolbar);
                Objects.requireNonNull(((MainActivity) getActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
                Objects.requireNonNull(((MainActivity) getActivity()).getSupportActionBar()).setDisplayShowHomeEnabled(true);
                Objects.requireNonNull(((MainActivity) getActivity()).getSupportActionBar()).setDisplayShowTitleEnabled(false);
            }
            toolbar.setNavigationOnClickListener(v -> {
                if (getActivity() != null) {
                    getActivity().onBackPressed();
                }
            });

            if (getArguments() != null) {
                ArticlesResponse.Article article = getArguments().getParcelable(AppConstants.ARTICLE);
                if (article != null) {
                    Glide.with(articleImg.getContext()).load(article.getMedia().get(0).getMediametadata().get(2).getUrl()).into(articleImg);
                    title.setText(article.getTitle());
                    byline.setText(article.getByline());
                    content.setText(article.getAbstractX());
                    published_date.setText(article.getPublished_date());
                    url.setText(article.getUrl());
                }
            }
        }
        return view;
    }

    @Override
    protected void setUp(View view) {

    }
}
