package com.hbacakk.sosyalmedya.ui.messageActivity.messageDetailsFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.hbacakk.sosyalmedya.R;
import com.hbacakk.sosyalmedya.data.models.User;
import com.hbacakk.sosyalmedya.databinding.FragmentMessageDetailsBinding;
import com.hbacakk.sosyalmedya.ui.BaseFragment;
import com.hbacakk.sosyalmedya.ui.messageActivity.conversationsFragment.ConversationsFragmentDirections;
import com.hbacakk.sosyalmedya.viewmodels.MainViewModel;

public class MessageDetailsFragment extends BaseFragment<FragmentMessageDetailsBinding> {
    MainViewModel mainViewModel;

    MessageAdapter messageAdapter;

    User user;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_message_details;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
    }

    private void initialize() {
        //region:
        mainViewModel=new ViewModelProvider(this).get(MainViewModel.class);
        //endregion
        //region:
        messageAdapter=new MessageAdapter("1",mainViewModel.getMessages());
        binding.recyclerViewMessage.setAdapter(messageAdapter);
        //endregion

        if (getArguments() == null) {
            Toast.makeText(getActivity(), "İllegal Erişim", Toast.LENGTH_SHORT).show();
        }
        user = MessageDetailsFragmentArgs.fromBundle(getArguments()).getUser();

        binding.setUser(user);


        //region: OnBack
        binding.imageViewBack.setOnClickListener(view->{
            Navigation.findNavController(binding.getRoot())
                    .navigate(MessageDetailsFragmentDirections.actionMessageDetailsFragmentToUserFragment());
        });
        //endregion
    }
}