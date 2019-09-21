package com.example.nytimesmostpopulararticles.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.example.nytimesmostpopulararticles.R;
import com.example.nytimesmostpopulararticles.models.response.ErrorBody;
import com.google.gson.Gson;

import retrofit2.Response;

public class AppManger {
    public static boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            return cm != null && cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected();
        } catch (Exception e) {
            return false;
        }
    }

    public static String onNextErrorMsg(Context context, Response response) {
        if (response.errorBody() != null) {
            ErrorBody errorBody = new Gson().fromJson(response.errorBody().charStream(), ErrorBody.class);
            return (errorBody.getErrors() != null && !errorBody.getErrors().isEmpty()) ?
                    errorBody.getErrors().get(0) : context.getString(R.string.connectionFailed_message);
        } else
            return context.getString(R.string.connectionFailed_message);
    }
}
