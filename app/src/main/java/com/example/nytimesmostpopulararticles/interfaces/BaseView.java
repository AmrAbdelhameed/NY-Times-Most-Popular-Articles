package com.example.nytimesmostpopulararticles.interfaces;

public interface BaseView {
    void init();

    void showProgress();

    void hideProgress();

    void errorMessage(String message);
}
