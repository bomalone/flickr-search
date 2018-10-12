package com.bomalone.flickrfindr2.ui.search;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.bomalone.flickrfindr2.R;
import com.bomalone.flickrfindr2.databinding.ActivitySearchBinding;
import com.bomalone.flickrfindr2.di.AppComponentHolder;

import javax.inject.Inject;

public class SearchActivity extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    SearchRecyclerAdapter adapter;

    private ActivitySearchBinding binding;

    private SearchViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppComponentHolder.getInstance().getApplicationComponent().inject(this);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel.class);

        adapter = new SearchRecyclerAdapter(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        binding.setViewmodel(viewModel);

        initUi();
    }


    private void initUi() {

        binding.recycler.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recycler.setAdapter(adapter);
        viewModel.getPhotosLiveData().observe(this, adapter::showResults);
    }


}
