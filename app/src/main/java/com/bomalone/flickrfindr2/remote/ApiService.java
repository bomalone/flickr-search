package com.bomalone.flickrfindr2.remote;

import com.bomalone.flickrfindr2.remote.response.SearchResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("rest/")
    Observable<SearchResponse> searchPhotos(@Query("text") String searchText);
}
