package com.bomalone.flickrfindr2.ui.search;

import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;

import com.bomalone.flickrfindr2.data.SearchRepository;
import com.bomalone.flickrfindr2.model.Photo;
import com.bomalone.flickrfindr2.remote.response.SearchResponse;
import com.bomalone.flickrfindr2.ui.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

public class SearchViewModel extends BaseViewModel {

//  I figure 1/3 of a second should be fine so we aren't searching on every character entered
//  private static final long DEBOUNCE_TIMEOUT = 333L;

    private final SearchRepository repository;

    private MutableLiveData<List<Photo>> photosLiveData = new MutableLiveData<>();

    @Inject
    public SearchViewModel(SearchRepository repository) {
        this.repository = repository;
    }

    public void searchImages(CharSequence searchTerm) {
        Timber.d("searching for images of %s", searchTerm);

        if (!TextUtils.isEmpty(searchTerm)) {
            disposable.add(repository.searchPhotos(searchTerm.toString())
                    .observeOn(AndroidSchedulers.mainThread())
//                    .debounce(DEBOUNCE_TIMEOUT, TimeUnit.MILLISECONDS)
                    .distinct()
                    .subscribe(this::addImages));
        }

    }

    private void addImages(SearchResponse response) {
        photosLiveData.setValue(response.getPhotos().getPhoto());
    }

    public MutableLiveData<List<Photo>> getPhotosLiveData() {
        return photosLiveData;
    }
}
