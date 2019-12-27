package com.example.nytimesmostpopulararticles_mvp.data;

import com.example.nytimesmostpopulararticles_mvp.data.db.DbHelper;
import com.example.nytimesmostpopulararticles_mvp.data.network.ApiHelper;
import com.example.nytimesmostpopulararticles_mvp.data.prefs.PreferencesHelper;

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {

}
