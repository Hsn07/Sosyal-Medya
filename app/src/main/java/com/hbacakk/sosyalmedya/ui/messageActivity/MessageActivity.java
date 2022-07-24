package com.hbacakk.sosyalmedya.ui.messageActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hbacakk.sosyalmedya.databinding.ActivityMessageBinding;

public class MessageActivity extends AppCompatActivity {

    ActivityMessageBinding messageBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        messageBinding = ActivityMessageBinding.inflate(getLayoutInflater());
        setContentView(messageBinding.getRoot());

    }

}