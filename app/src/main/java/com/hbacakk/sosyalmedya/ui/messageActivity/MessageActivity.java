package com.hbacakk.sosyalmedya.ui.messageActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.hbacakk.sosyalmedya.R;
import com.hbacakk.sosyalmedya.databinding.ActivityMessageBinding;
import com.hbacakk.sosyalmedya.viewmodels.MainViewModel;

public class MessageActivity extends AppCompatActivity {

    ActivityMessageBinding messageBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        messageBinding=ActivityMessageBinding.inflate(getLayoutInflater());
        setContentView(messageBinding.getRoot());

    }

    @Override
    public void onBackPressed() {
    }
}