package com.example.nytimesmostpopulararticles.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nytimesmostpopulararticles.R;
import com.example.nytimesmostpopulararticles.interfaces.OnClickListener;
import com.example.nytimesmostpopulararticles.models.response.ArticlesResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.MyViewHolder> {
    private Context context;
    private OnClickListener onClickListener;
    private List<ArticlesResponse.ResultsBean> resultsBeans;

    public ArticlesAdapter(Context context, OnClickListener onClickListener) {
        this.context = context;
        this.onClickListener = onClickListener;
        this.resultsBeans = new ArrayList<>();
    }

    public List<ArticlesResponse.ResultsBean> getResultsBeans() {
        return resultsBeans;
    }

    public void setResultsBeans(List<ArticlesResponse.ResultsBean> resultsBeans) {
        this.resultsBeans.addAll(resultsBeans);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ArticlesResponse.ResultsBean resultsBean = resultsBeans.get(position);
        holder.bind(resultsBean);
    }

    @Override
    public int getItemCount() {
        return resultsBeans.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.byline)
        TextView byline;
        @BindView(R.id.published_date)
        TextView published_date;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.cardView)
        public void cardView(View view) {
            if (getAdapterPosition() != -1) {
                onClickListener.onClick(view, getAdapterPosition());
            }
        }

        private void bind(ArticlesResponse.ResultsBean resultsBean) {
            title.setText(resultsBean.getTitle());
            byline.setText(resultsBean.getByline());
            published_date.setText(resultsBean.getPublished_date());
        }
    }
}
