package com.bomalone.flickrfindr2.di;

import android.app.Application;
import android.content.Context;

import com.bomalone.flickrfindr2.util.FlickrUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    FlickrUtil provideFlickrUtil() {
        return new FlickrUtil();
    }
}
