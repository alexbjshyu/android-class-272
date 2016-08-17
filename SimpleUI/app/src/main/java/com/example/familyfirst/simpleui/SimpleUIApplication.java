package com.example.familyfirst.simpleui;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by familyfirst on 8/16/16.
 */
public class SimpleUIApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("3hJ9WqJNPGWQBkAvhVTJjzwG93MEBdePPL7ZbVrf")
                .server("https://parseapi.back4app.com/")
                .clientKey("VVTg4VAdK9kRa6lL6X75N9wHmYXprbSarSppJKhk")
        .build()
        );
    }
}
