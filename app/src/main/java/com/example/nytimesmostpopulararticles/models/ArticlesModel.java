package com.example.nytimesmostpopulararticles.models;

import android.content.Context;

import com.example.nytimesmostpopulararticles.R;
import com.example.nytimesmostpopulararticles.interfaces.ArticlesContract;
import com.example.nytimesmostpopulararticles.models.response.ArticlesResponse;
import com.example.nytimesmostpopulararticles.network.APIService;
import com.example.nytimesmostpopulararticles.network.MyCallbackResponse;
import com.example.nytimesmostpopulararticles.network.ObserverHelper;
import com.example.nytimesmostpopulararticles.network.RetrofitClient;
import com.example.nytimesmostpopulararticles.utils.AppManger;
import com.example.nytimesmostpopulararticles.utils.Constants;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ArticlesModel implements ArticlesContract.Model {
    private Context context;
    private APIService apiService;

    public ArticlesModel(Context context) {
        this.context = context;
        apiService = RetrofitClient.getApiClient().create(APIService.class);
    }

    @Override
    public void getMostPopularArticles(int period, final MyCallbackResponse<ArticlesResponse> myCallbackResponse) {
        apiService.getMostPopularArticles(period, Constants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ObserverHelper<Response<ArticlesResponse>>() {
                    @Override
                    public void onNext(Response<ArticlesResponse> response) {
                        if (response.isSuccessful())
                            myCallbackResponse.onSuccess(response.body());
                        else
                            myCallbackResponse.onFailed(AppManger.onNextErrorMsg(context, response));
                    }

                    @Override
                    public void onError(Throwable e) {
                        myCallbackResponse.onFailed(AppManger.isOnline(context) ? e.getMessage()
                                : context.getString(R.string.no_internet_message));
                    }
                });
    }
}