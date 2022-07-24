package com.hbacakk.sosyalmedya.ui.messageActivity.conversationsFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.hbacakk.sosyalmedya.R;
import com.hbacakk.sosyalmedya.data.models.User;
import com.hbacakk.sosyalmedya.databinding.FragmentConversationsBinding;
import com.hbacakk.sosyalmedya.ui.BaseFragment;
import com.hbacakk.sosyalmedya.ui.main.MainActivity;
import com.hbacakk.sosyalmedya.ui.messageActivity.MessageActivity;
import com.hbacakk.sosyalmedya.viewmodels.MainViewModel;

public class ConversationsFragment extends BaseFragment<FragmentConversationsBinding> implements ConversationListener {

    MainViewModel mainViewModel;
    UserAdapter userAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
    }

    private void initialize() {
        //region:
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        //endregion
        //region:
        userAdapter = new UserAdapter(mainViewModel.getUsers());
        userAdapter.setListener(this);
        binding.recyclerViewConversations.setAdapter(userAdapter);
        //endregion
        //region:
        binding.imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        //endregion
    }

    @Override
    public void SelectConversation(User user) {
        Navigation.findNavController(binding.getRoot())
                .navigate(ConversationsFragmentDirections.actionUserFragmentToMessageDetailsFragment(user));
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_conversations;
    }
}