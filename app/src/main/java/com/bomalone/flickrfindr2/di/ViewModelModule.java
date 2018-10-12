package com.bomalone.flickrfindr2.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.bomalone.flickrfindr2.ui.search.SearchViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);

    @ViewModelKey(SearchViewModel.class)
    @IntoMap
    @Binds
    abstract ViewModel bindsSearchViewmodel(SearchViewModel viewModel);
}