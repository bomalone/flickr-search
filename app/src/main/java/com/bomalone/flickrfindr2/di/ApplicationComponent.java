package com.bomalone.flickrfindr2.di;

import com.bomalone.flickrfindr2.ui.imagedetail.ImageDetailActivity;
import com.bomalone.flickrfindr2.ui.search.SearchActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ViewModelModule.class,
        NetworkModule.class
})

public interface ApplicationComponent {

    void inject(ImageDetailActivity imageDetailActivity);

    void inject(SearchActivity searchActivity);
}