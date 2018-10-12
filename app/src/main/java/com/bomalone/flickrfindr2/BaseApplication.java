package com.bomalone.flickrfindr2;

import android.app.Application;

import com.bomalone.flickrfindr2.di.AppComponentHolder;
import com.bomalone.flickrfindr2.di.ApplicationModule;
import com.bomalone.flickrfindr2.di.DaggerApplicationComponent;

import timber.log.Timber;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        AppComponentHolder.getInstance().setApplicationComponent(DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build());
    }
}
