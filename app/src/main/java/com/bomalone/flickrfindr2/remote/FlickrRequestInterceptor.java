package com.bomalone.flickrfindr2.remote;


import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class FlickrRequestInterceptor implements Interceptor {

    private static final String API_KEY = "api_key";
    private static final String FORMAT = "format";
    private static final String JSON = "json";
    private static final String JSON_CALLBACK = "nojsoncallback";
    private static final String JSON_CALLBACK_VALUE = "1";
    private static final String PER_PAGE = "perpage";
    private static final String PER_PAGE_AMOUNT = "25";
    private static final String API_KEY_VALUE = "TODO_YOUR_API_KEY_HERE";
    private static final String METHOD = "method";
    private static final String SEARCH_METHOD = "flickr.photos.search";

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        HttpUrl originalHttpUrl = originalRequest.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter(API_KEY, API_KEY_VALUE)
                .addQueryParameter(FORMAT, JSON)
                .addQueryParameter(JSON_CALLBACK, JSON_CALLBACK_VALUE)
                .addQueryParameter(METHOD, SEARCH_METHOD)
                .addQueryParameter(PER_PAGE, PER_PAGE_AMOUNT)
                .build();

        Request request = originalRequest.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}