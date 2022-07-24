package com.hbacakk.sosyalmedya.ui.main.homefragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.hbacakk.sosyalmedya.R;
import com.hbacakk.sosyalmedya.databinding.FragmentHomeBinding;
import com.hbacakk.sosyalmedya.ui.BaseFragment;
import com.hbacakk.sosyalmedya.viewmodels.MainViewModel;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> {

    MainViewModel mainViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
    }

    private void initialize() {

        //region:
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        //endregion
        // region:
        binding.recyclerViewPosts.setAdapter(new PostAdapter(mainViewModel.getPosts(), getActivity()));
        //endregion
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home;
    }
}