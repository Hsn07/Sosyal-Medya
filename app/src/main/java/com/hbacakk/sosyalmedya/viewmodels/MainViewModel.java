package com.hbacakk.sosyalmedya.viewmodels;

import androidx.lifecycle.ViewModel;

import com.hbacakk.sosyalmedya.data.models.Feed;
import com.hbacakk.sosyalmedya.data.models.Item;
import com.hbacakk.sosyalmedya.data.models.Message;
import com.hbacakk.sosyalmedya.data.models.OnboardingItem;
import com.hbacakk.sosyalmedya.data.models.User;
import com.hbacakk.sosyalmedya.repositories.MainRepository;

import java.util.ArrayList;
import java.util.Arrays;

public class MainViewModel extends ViewModel {

    MainRepository mainRepository;

    public MainViewModel() {
        mainRepository = new MainRepository();
    }

    public ArrayList<OnboardingItem> getOnBoardingItems() {
        return new ArrayList<>(Arrays.asList(mainRepository.items));
    }

    public ArrayList<Item> getPosts() {
        return new ArrayList<>(Arrays.asList(mainRepository.posts));
    }

    public ArrayList<Message> getMessages() {
        return new ArrayList<>(Arrays.asList(mainRepository.messages));
    }

    public ArrayList<Feed> getMyPost() {
        return new ArrayList<>(Arrays.asList(mainRepository.mypost));
    }

    public ArrayList<User> getUsers() {
        return new ArrayList<>(Arrays.asList(mainRepository.users));
    }
}
