package com.example.nytimesmostpopulararticles_mvp.ui.main.article;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.nytimesmostpopulararticles_mvp.R;
import com.example.nytimesmostpopulararticles_mvp.data.network.model.ArticlesResponse;
import com.example.nytimesmostpopulararticles_mvp.ui.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ArticleAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    private List<ArticlesResponse.Article> articleList;

    public ArticleAdapter(List<ArticlesResponse.Article> articleList) {
        this.articleList = articleList;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article_view, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (articleList != null && articleList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (articleList != null && articleList.size() > 0) {
            return articleList.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<ArticlesResponse.Article> articleList) {
        this.articleList.addAll(articleList);
        notifyDataSetChanged();
    }

    public interface Callback {
        void onArticleEmptyViewRetryClick();

        void onItemClick(ArticlesResponse.Article article);
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.articleImg)
        ImageView articleImg;

        @BindView(R.id.title)
        TextView title;

        @BindView(R.id.byline)
        TextView byline;

        @BindView(R.id.published_date)
        TextView published_date;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            articleImg.setImageDrawable(null);
            title.setText("");
            byline.setText("");
            published_date.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final ArticlesResponse.Article article = articleList.get(position);

            String url = article.getMedia().get(0).getMediametadata().get(1).getUrl();
            if (url != null) {
                Glide.with(articleImg.getContext()).load(url).apply(RequestOptions.circleCropTransform()).into(articleImg);
            }

            if (article.getTitle() != null) {
                title.setText(article.getTitle());
            }

            if (article.getByline() != null) {
                byline.setText(article.getByline());
            }

            if (article.getPublished_date() != null) {
                published_date.setText(article.getPublished_date());
            }

            itemView.setOnClickListener(v -> {
                mCallback.onItemClick(article);
            });
        }
    }

    public class EmptyViewHolder extends BaseViewHolder {

        @BindView(R.id.btn_retry)
        Button retryButton;

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }

        @OnClick(R.id.btn_retry)
        void onRetryClick() {
            if (mCallback != null)
                mCallback.onArticleEmptyViewRetryClick();
        }
    }
}
