package com.bomalone.flickrfindr2.ui.search;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bomalone.flickrfindr2.R;
import com.bomalone.flickrfindr2.model.Photo;
import com.bomalone.flickrfindr2.ui.imagedetail.ImageDetailActivity;
import com.bomalone.flickrfindr2.util.FlickrUtil;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;

public class SearchRecyclerAdapter extends RecyclerView.Adapter<SearchRecyclerAdapter.SearchRecyclerViewHolder> {

    private List<Photo> photos;
    private final Context context;

    @Inject
    public SearchRecyclerAdapter(Context context) {
        this.context = context;
        photos = new ArrayList<>();
    }

    public void showResults(List<Photo> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_search_preview, parent, false);
        return new SearchRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchRecyclerViewHolder viewHolder, int position) {
        Photo photo = photos.get(position);

        if(photo != null) {
            int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;

            String url = FlickrUtil.getImageUrl(photo);
            Timber.d("Loading image from %s", url);
            Glide.with(context)
                    .load(url)
//                    .apply(new RequestOptions().override(screenWidth / 2 - 10).centerCrop())
                    .into(viewHolder.imageView);

            viewHolder.imageView.setOnClickListener(v -> context.startActivity(ImageDetailActivity.newIntent(context, photo)));

            viewHolder.textView.setText(photo.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        if(photos != null) {
            return photos.size();
        }

        return 0;
    }

    static class SearchRecyclerViewHolder extends RecyclerView.ViewHolder {

        final ImageView imageView;
        final TextView textView;

        SearchRecyclerViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.search_preview_thumbnail);
            textView = view.findViewById(R.id.search_preview_title);
        }

        ImageView getImageView() {
            return imageView;
        }
    }
}
