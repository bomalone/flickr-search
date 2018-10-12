package com.bomalone.flickrfindr2.data;

import com.bomalone.flickrfindr2.remote.ApiService;
import com.bomalone.flickrfindr2.remote.response.SearchResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class SearchRepository {

    //TODO move all this into a request interceptor
    private static final int PER_PAGE = 25;
    private static final String API_KEY = "1508443e49213ff84d566777dc211f2a";
    private static final String FORMAT_JSON = "json";
    private static final String SEARCH_METHOD = "flickr.photos.search";

    ApiService apiService;

    @Inject
    public SearchRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<SearchResponse> searchPhotos(String searchTerm) {
        return apiService.searchPhotos(searchTerm)
                .subscribeOn(Schedulers.io());
    }
}
