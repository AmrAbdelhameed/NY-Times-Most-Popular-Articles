package com.example.nytimesmostpopulararticles.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class IntentHelper {
    public static void openActivity(Activity activity, Class<?> calledActivity, Bundle bundle) {
        Intent intent = new Intent(activity, calledActivity);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }
}
