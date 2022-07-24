package com.hbacakk.sosyalmedya.ui.splashActivity;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.hbacakk.sosyalmedya.R;
import com.hbacakk.sosyalmedya.data.models.OnboardingItem;
import com.hbacakk.sosyalmedya.databinding.ItemOnboardingPagerBinding;

import java.util.ArrayList;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.ViewHolder> {

    ArrayList<OnboardingItem> onboardingItems;

    public OnboardingAdapter(ArrayList<OnboardingItem> onboardingItems) {
        this.onboardingItems = onboardingItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_onboarding_pager,
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(onboardingItems.get(position));
    }

    @Override
    public int getItemCount() {
        return onboardingItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ItemOnboardingPagerBinding itemBinding;

        public ViewHolder(ItemOnboardingPagerBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        void setData(OnboardingItem item) {
            itemBinding.imageViewImage.setImageResource(item.imageID);
            itemBinding.textViewPrimary.setText(item.message);
            itemBinding.textViewSecondary.setText(item.title);
            itemBinding.executePendingBindings();
        }
    }
}
