package com.example.nytimesmostpopulararticles.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.nytimesmostpopulararticles.R;
import com.example.nytimesmostpopulararticles.models.response.ArticlesResponse;
import com.example.nytimesmostpopulararticles.utils.AppManger;
import com.example.nytimesmostpopulararticles.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.byline)
    TextView byline;
    @BindView(R.id.published_date)
    TextView published_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        init();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ArticlesResponse.ResultsBean resultsBean = bundle.getParcelable(Constants.Bundle.ARTICLE);
            if (resultsBean != null) {
                title.setText(resultsBean.getTitle());
                byline.setText(resultsBean.getByline());
                published_date.setText(resultsBean.getPublished_date());
            }
        }
    }

    private void init() {
        ButterKnife.bind(this);
        AppManger.setToolBarOptions(this, toolbar);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
