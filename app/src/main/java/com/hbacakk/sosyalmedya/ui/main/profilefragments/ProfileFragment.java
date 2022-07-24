package com.hbacakk.sosyalmedya.ui.main.profilefragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hbacakk.sosyalmedya.R;
import com.hbacakk.sosyalmedya.databinding.FragmentProfileBinding;
import com.hbacakk.sosyalmedya.ui.BaseFragment;
import com.hbacakk.sosyalmedya.viewmodels.MainViewModel;

public class ProfileFragment extends BaseFragment<FragmentProfileBinding> {

    MainViewModel mainViewModel;
    MyPostAdapter postAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
    }

    private void initialize() {
        //region: mainViewModel
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        //endregion
        // region: Post
        postAdapter=new MyPostAdapter(mainViewModel.getMyPost());
        binding.recyclerViewPosts.setAdapter(postAdapter);
        //endregion
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_profile;
    }
}