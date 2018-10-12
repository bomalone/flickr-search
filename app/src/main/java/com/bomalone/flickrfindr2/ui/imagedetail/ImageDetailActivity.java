package com.bomalone.flickrfindr2.ui.imagedetail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bomalone.flickrfindr2.R;
import com.bomalone.flickrfindr2.databinding.ActivityImageResultBinding;
import com.bomalone.flickrfindr2.model.Photo;
import com.bomalone.flickrfindr2.util.FlickrUtil;
import com.bumptech.glide.Glide;

import javax.inject.Inject;

public class ImageDetailActivity extends AppCompatActivity {

    private static final String KEY_BUNDLE_IMAGE_URL = "KEY_BUNDLE_RECENT_URL";

    @Inject
    FlickrUtil flickrUtil;

    private ActivityImageResultBinding binding;

    public static Intent newIntent(Context context, Photo photo) {
        Intent intent = new Intent(context, ImageDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(KEY_BUNDLE_IMAGE_URL, FlickrUtil.getImageUrl(photo));
        intent.putExtras(bundle);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Bundle bundle = getIntent().getExtras();
        String url = "";
        if (bundle != null) {
            url = bundle.getString(KEY_BUNDLE_IMAGE_URL);
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_result);

        Glide.with(this)
                .load(url)
                .into(binding.imageView);

    }
}
