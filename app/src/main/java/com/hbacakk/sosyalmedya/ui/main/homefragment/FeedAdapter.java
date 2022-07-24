package com.hbacakk.sosyalmedya.ui.main.homefragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.hbacakk.sosyalmedya.R;
import com.hbacakk.sosyalmedya.data.models.Feed;
import com.hbacakk.sosyalmedya.data.models.Item;
import com.hbacakk.sosyalmedya.databinding.ItemAddFeedBinding;
import com.hbacakk.sosyalmedya.databinding.ItemFeedBinding;
import com.hbacakk.sosyalmedya.databinding.ItemFeedContainerBinding;
import com.hbacakk.sosyalmedya.databinding.ItemTitleBinding;
import com.hbacakk.sosyalmedya.utilities.Constants;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Item> itemArrayList;

    public FeedAdapter(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Constants.ROW_TYPE_FEED) {
            return new ViewHolderFeed(ItemFeedBinding.inflate(
                    LayoutInflater.from(parent.getContext()),
                    parent,
                    false
            ));
        } else if (viewType == Constants.ROW_TYPE_ADD_FEED) {
            return new ViewHolderAddFeed(ItemAddFeedBinding.inflate(
                    LayoutInflater.from(parent.getContext()),
                    parent,
                    false
            ));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == Constants.ROW_TYPE_FEED) {
            ((ViewHolderFeed) holder).setData((Feed) itemArrayList.get(position).getData());
        } else if (getItemViewType(position) == Constants.ROW_TYPE_ADD_FEED) {
            ((ViewHolderAddFeed) holder).setData();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (itemArrayList.get(position)==null)
            return -1;

        return itemArrayList.get(position).getRowType();
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class ViewHolderFeed extends RecyclerView.ViewHolder {
        ItemFeedBinding feedBinding;

        public ViewHolderFeed(ItemFeedBinding feedBinding) {
            super(feedBinding.getRoot());
            this.feedBinding = feedBinding;
        }

        public void setData(Feed feed) {
            feedBinding.imageFeed.setImageResource(feed.imageId);
            feedBinding.executePendingBindings();
        }

    }
    public class ViewHolderAddFeed extends RecyclerView.ViewHolder {
        ItemAddFeedBinding addFeedBinding;

        public ViewHolderAddFeed(ItemAddFeedBinding addFeedBinding) {
            super(addFeedBinding.getRoot());
            this.addFeedBinding = addFeedBinding;
        }

        public void setData() {
            addFeedBinding.executePendingBindings();
        }

    }
}
