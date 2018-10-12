package com.bomalone.flickrfindr2.di;

import com.bomalone.flickrfindr2.ui.imagedetail.ImageDetailActivity;
import com.bomalone.flickrfindr2.ui.search.SearchActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract SearchActivity contributeSearchActivity();

    @ContributesAndroidInjector
    abstract ImageDetailActivity contributeImageDetailActivity();
}