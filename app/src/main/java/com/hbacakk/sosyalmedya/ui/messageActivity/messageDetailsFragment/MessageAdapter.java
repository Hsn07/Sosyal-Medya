package com.hbacakk.sosyalmedya.ui.messageActivity.messageDetailsFragment;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hbacakk.sosyalmedya.data.models.Message;
import com.hbacakk.sosyalmedya.databinding.ItemMessageReceivedBinding;
import com.hbacakk.sosyalmedya.databinding.ItemMessageSendBinding;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    String senderID;
    ArrayList<Message> messageArrayList;
    static int VIEW_TYPE_SEND = 1;
    static int VIEW_TYPE_RECEIVED = 2;

    public MessageAdapter(String senderID, ArrayList<Message> messageArrayList) {
        this.senderID = senderID;
        this.messageArrayList = messageArrayList;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addItem(Message message) {
        messageArrayList.add(message);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_SEND) {
            return new SendMessageViewHolder(ItemMessageSendBinding.inflate(
                    LayoutInflater.from(parent.getContext()),
                    parent,
                    false
            ));
        } else {
            return new ReceivedMessageViewHolder(ItemMessageReceivedBinding.inflate(
                    LayoutInflater.from(parent.getContext()),
                    parent,
                    false
            ));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_SEND) {
            ((SendMessageViewHolder) holder).setData(messageArrayList.get(position));
        } else {
            ((ReceivedMessageViewHolder) holder).setData(messageArrayList.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (messageArrayList.get(position).getUserID().equals(senderID)) {
            return VIEW_TYPE_SEND;
        } else {
            return VIEW_TYPE_RECEIVED;
        }
    }

    @Override
    public int getItemCount() {
        return messageArrayList.size();
    }

    static class SendMessageViewHolder extends RecyclerView.ViewHolder {
        ItemMessageSendBinding sendBinding;

        public SendMessageViewHolder(ItemMessageSendBinding rightBinding) {
            super(rightBinding.getRoot());
            this.sendBinding = rightBinding;
        }

        private void setData(Message message) {
            sendBinding.setMessage(message.getMessage());
            sendBinding.executePendingBindings();
        }
    }

    static class ReceivedMessageViewHolder extends RecyclerView.ViewHolder {
        ItemMessageReceivedBinding receivedBinding;

        public ReceivedMessageViewHolder(ItemMessageReceivedBinding leftBinding) {
            super(leftBinding.getRoot());
            this.receivedBinding = leftBinding;
        }

        private void setData(Message message) {
            receivedBinding.setMessage(message.getMessage());
            receivedBinding.executePendingBindings();
        }
    }
}
