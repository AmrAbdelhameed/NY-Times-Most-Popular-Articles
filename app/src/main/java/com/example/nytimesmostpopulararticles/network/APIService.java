package com.example.nytimesmostpopulararticles.network;

import com.example.nytimesmostpopulararticles.models.response.ArticlesResponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @GET("svc/mostpopular/v2/viewed/{period}.json")
    Observable<Response<ArticlesResponse>> getMostPopularArticles(@Path("period") int period,
                                                                  @Query("api-key") String apiKey);
}