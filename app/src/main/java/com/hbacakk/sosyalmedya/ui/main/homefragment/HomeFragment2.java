package com.hbacakk.sosyalmedya.ui.main.homefragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.hbacakk.sosyalmedya.R;
import com.hbacakk.sosyalmedya.databinding.FragmentHome2Binding;
import com.hbacakk.sosyalmedya.ui.BaseFragment;
import com.hbacakk.sosyalmedya.viewmodels.MainViewModel;

public class HomeFragment2 extends BaseFragment<FragmentHome2Binding> {

    MainViewModel mainViewModel;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home2;
    }

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

        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
            binding.swipeRefreshLayout.setRefreshing(true);
            binding.swipeRefreshLayout.setRefreshing(false);
        });
    }
}