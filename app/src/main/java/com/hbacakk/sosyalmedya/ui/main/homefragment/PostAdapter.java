package com.hbacakk.sosyalmedya.ui.main.homefragment;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hbacakk.sosyalmedya.R;
import com.hbacakk.sosyalmedya.data.models.Item;
import com.hbacakk.sosyalmedya.data.models.Post;
import com.hbacakk.sosyalmedya.databinding.ItemFeedContainerBinding;
import com.hbacakk.sosyalmedya.databinding.ItemPostBinding;
import com.hbacakk.sosyalmedya.databinding.ItemTitleBinding;
import com.hbacakk.sosyalmedya.utilities.Constants;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Item> itemArrayList;
    Activity activity;

    public PostAdapter(ArrayList<Item> itemArrayList,Activity activity) {
        this.itemArrayList = itemArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Constants.ROW_TYPE_TITLE) {
            return new ViewHolderTitle(ItemTitleBinding.inflate(
                    LayoutInflater.from(parent.getContext()),
                    parent,
                    false
            ));
        } else if (viewType == Constants.ROW_TYPE_FEEDS) {
            return new ViewHolderFeeds(ItemFeedContainerBinding.inflate(
                    LayoutInflater.from(parent.getContext()),
                    parent,
                    false
            ));
        } else {
            return new ViewHolderPost(ItemPostBinding.inflate(
                    LayoutInflater.from(parent.getContext()),
                    parent,
                    false
            ));
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == Constants.ROW_TYPE_TITLE) {
            ((ViewHolderTitle) holder).setData((String) itemArrayList.get(position).getData());
        } else if (getItemViewType(position) == Constants.ROW_TYPE_FEEDS) {
            ((ViewHolderFeeds) holder).setData((ArrayList<Item>) itemArrayList.get(position).getData());
        } else if (getItemViewType(position)==Constants.ROW_TYPE_POST){
            ((ViewHolderPost) holder).setData((Post) itemArrayList.get(position).getData());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (itemArrayList.get(position) != null)
            return itemArrayList.get(position).getRowType();
        return 0;
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class ViewHolderPost extends RecyclerView.ViewHolder {
        ItemPostBinding itemPostBinding;

        public ViewHolderPost(ItemPostBinding itemPostBinding) {
            super(itemPostBinding.getRoot());
            this.itemPostBinding = itemPostBinding;
        }

        public void setData(Post post) {
            itemPostBinding.imageUserImage.setImageResource(post.imageId);
            itemPostBinding.imagePost.setImageResource(post.postId);
            itemPostBinding.setPost(post);
            itemPostBinding.imageViewSettings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu popupMenu=new PopupMenu(activity,view);
                    popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
                    popupMenu.show();
                }
            });
            itemPostBinding.executePendingBindings();
        }

    }

    public class ViewHolderTitle extends RecyclerView.ViewHolder {
        ItemTitleBinding binding;

        public ViewHolderTitle(ItemTitleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setData(String title) {
            binding.setTitle(title);
            binding.executePendingBindings();
        }
    }

    public class ViewHolderFeeds extends RecyclerView.ViewHolder {
        ItemFeedContainerBinding binding;

        public ViewHolderFeeds(ItemFeedContainerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setData(ArrayList<Item> arrayList) {
            binding.recyclerViewFeeds.setAdapter(new FeedAdapter(arrayList));
            binding.executePendingBindings();
        }

    }
}
