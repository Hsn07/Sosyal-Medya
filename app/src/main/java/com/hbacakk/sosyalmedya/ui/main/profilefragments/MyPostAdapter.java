package com.hbacakk.sosyalmedya.ui.main.profilefragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.hbacakk.sosyalmedya.R;
import com.hbacakk.sosyalmedya.data.models.Feed;
import com.hbacakk.sosyalmedya.databinding.ItemMyPostBinding;

import java.util.ArrayList;

public class MyPostAdapter extends RecyclerView.Adapter<MyPostAdapter.ViewHolder> {

    ArrayList<Feed> feedArrayList;

    public MyPostAdapter(ArrayList<Feed> feeds) {
        this.feedArrayList = feeds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_my_post,
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(feedArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return feedArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemMyPostBinding postBinding;

        public ViewHolder(ItemMyPostBinding postBinding) {
            super(postBinding.getRoot());
            this.postBinding = postBinding;
        }

        public void setData(Feed post) {

            postBinding.imagePost.setImageResource(post.imageId);
            postBinding.executePendingBindings();
        }

    }
}
