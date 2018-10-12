package com.bomalone.flickrfindr2.util;

import com.bomalone.flickrfindr2.model.Photo;

public class FlickrUtil {

    private static final String URL_FORMAT = "https://farm%1$s.staticflickr.com/%2$s/%3$s_%4$s.jpg";

    public static String getImageUrl(Photo photo) {

        return String.format(URL_FORMAT, photo.getFarm(), photo.getServer(), photo.getId(), photo.getSecret());
    }
}
