package com.hbacakk.sosyalmedya.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;
import com.hbacakk.sosyalmedya.R;
import com.hbacakk.sosyalmedya.databinding.ActivityMainBinding;
import com.hbacakk.sosyalmedya.ui.main.homefragment.HomeFragment;
import com.hbacakk.sosyalmedya.ui.main.homefragment.HomeFragment2;
import com.hbacakk.sosyalmedya.ui.main.profilefragments.ProfileFragment;
import com.hbacakk.sosyalmedya.ui.messageActivity.MessageActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());


        mainBinding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.itemHome:
                        loadFragment(new HomeFragment());
                        return true;
                    case R.id.itemProfile:
                        loadFragment(new ProfileFragment());
                        return true;
                    case R.id.itemMessage:
                        startActivity(new Intent(getApplicationContext(), MessageActivity.class));
                        break;
                    case R.id.itemFavorite:
                        loadFragment(new HomeFragment2());
                        return true;
                }
                return false;
            }
        });

        loadFragment(new HomeFragment());


    }
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, fragment, null)
                .commit();
    }
}