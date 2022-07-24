package com.hbacakk.sosyalmedya.ui.messageActivity.conversationsFragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.hbacakk.sosyalmedya.R;
import com.hbacakk.sosyalmedya.data.models.User;
import com.hbacakk.sosyalmedya.databinding.FragmentConversationsBinding;
import com.hbacakk.sosyalmedya.ui.BaseFragment;
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
        binding.imageViewBack.setOnClickListener(view -> getActivity().finish());
        //endregion

        binding.inputContacts.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                userAdapter.search(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
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