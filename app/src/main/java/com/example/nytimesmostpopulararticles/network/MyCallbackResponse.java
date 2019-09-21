package com.example.nytimesmostpopulararticles.network;

public interface MyCallbackResponse<T> {
    void onSuccess(T response);

    void onFailed(String message);
}