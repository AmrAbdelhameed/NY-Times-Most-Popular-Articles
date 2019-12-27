package com.example.nytimesmostpopulararticles.data;

import com.example.nytimesmostpopulararticles.data.db.DbHelper;
import com.example.nytimesmostpopulararticles.data.network.ApiHelper;
import com.example.nytimesmostpopulararticles.data.prefs.PreferencesHelper;

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {

}
