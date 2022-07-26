package com.hbacakk.sosyalmedya.ui.messageActivity.conversationsFragment;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hbacakk.sosyalmedya.data.models.User;
import com.hbacakk.sosyalmedya.databinding.ItemUserBinding;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    ArrayList<User> userArrayList;
    ArrayList<User> sourceUserArrayList;
    ConversationListener listener;

    public UserAdapter(ArrayList<User> users) {

        this.userArrayList = users;
        sourceUserArrayList = users;
    }

    public void setListener(ConversationListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new UserAdapter.ViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(userArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemUserBinding itemUserBinding;

        public ViewHolder(ItemUserBinding itemUserBinding) {
            super(itemUserBinding.getRoot());
            this.itemUserBinding = itemUserBinding;
        }

        public void setData(User user) {
            itemUserBinding.setUser(user);
            itemUserBinding.imageProfile.setImageResource(user.imageId);
            itemUserBinding.userContainer.setOnClickListener(view -> listener.SelectConversation(user));
            itemUserBinding.executePendingBindings();
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    public void search(final String searchKeyword) {
        if (searchKeyword.trim().isEmpty()) {
            userArrayList = sourceUserArrayList;
        } else {
            ArrayList<User> temp = new ArrayList<>();
            for (User user : sourceUserArrayList) {
                if (user.getUserName().toLowerCase().trim().contains(searchKeyword.toLowerCase())) {
                    temp.add(user);
                }
            }
            userArrayList = temp;
        }
        notifyDataSetChanged();
    }
}
