package com.hbacakk.sosyalmedya.repositories;

import com.hbacakk.sosyalmedya.R;
import com.hbacakk.sosyalmedya.data.models.Feed;
import com.hbacakk.sosyalmedya.data.models.Item;
import com.hbacakk.sosyalmedya.data.models.Message;
import com.hbacakk.sosyalmedya.data.models.OnboardingItem;
import com.hbacakk.sosyalmedya.data.models.Post;
import com.hbacakk.sosyalmedya.data.models.User;
import com.hbacakk.sosyalmedya.utilities.Constants;

import java.util.ArrayList;
import java.util.Arrays;

public class MainRepository {

    public final OnboardingItem[] items = new OnboardingItem[]{
            new OnboardingItem("Socially", "Welcome to", R.drawable.ic_frame_1),
            new OnboardingItem("Socially", "Welcome to", R.drawable.ic_frame_3),
            new OnboardingItem("Socially", "Welcome to", R.drawable.ic_frame_2)
    };
    public final Feed[] mypost = new Feed[]{
            new Feed(R.drawable.my_post_1),
            new Feed(R.drawable.my_post_2),
            new Feed(R.drawable.my_post_3),
            new Feed(R.drawable.my_post_1),
            new Feed(R.drawable.my_post_2),
            new Feed(R.drawable.my_post_3),
            new Feed(R.drawable.my_post_1),
            new Feed(R.drawable.my_post_2),
            new Feed(R.drawable.my_post_3)
    };



    public final Item[] feeds = new Item[]{
            new Item(Constants.ROW_TYPE_ADD_FEED,null),
            new Item(Constants.ROW_TYPE_FEED,new Feed(R.drawable.my_post_1)),
            new Item(Constants.ROW_TYPE_FEED,new Feed(R.drawable.my_post_2)),
            new Item(Constants.ROW_TYPE_FEED,new Feed(R.drawable.my_post_3)),
            new Item(Constants.ROW_TYPE_FEED,new Feed(R.drawable.my_post_1)),
            new Item(Constants.ROW_TYPE_FEED,new Feed(R.drawable.my_post_2)),
            new Item(Constants.ROW_TYPE_FEED,new Feed(R.drawable.my_post_3)),
            new Item(Constants.ROW_TYPE_FEED,new Feed(R.drawable.my_post_1)),
            new Item(Constants.ROW_TYPE_FEED,new Feed(R.drawable.my_post_2)),
            new Item(Constants.ROW_TYPE_FEED,new Feed(R.drawable.my_post_3))
    };
    public final Item[] posts = new Item[]{
            new Item(Constants.ROW_TYPE_TITLE,"Feeds"),
            new Item(Constants.ROW_TYPE_FEEDS,new ArrayList<Item>(Arrays.asList(feeds))),
            new Item(Constants.ROW_TYPE_POST,new Post(R.drawable.post_user_1, R.drawable.post_1, "Dennis Reynolds", "2 hrs ago", "5.2K", "1.1K", "362")),
            new Item(Constants.ROW_TYPE_POST,new Post(R.drawable.post_user_2, R.drawable.post_2, "Charlie Kelly", "4 hrs ago", "5.2K", "1.1K", "362")),
            new Item(Constants.ROW_TYPE_POST,new Post(R.drawable.post_user_1, R.drawable.post_1, "Dennis Reynolds", "2 hrs ago", "5.2K", "1.1K", "362")),
            new Item(Constants.ROW_TYPE_POST,new Post(R.drawable.post_user_2, R.drawable.post_2, "Charlie Kelly", "4 hrs ago", "5.2K", "1.1K", "362")),
            new Item(Constants.ROW_TYPE_POST,new Post(R.drawable.post_user_1, R.drawable.post_1, "Dennis Reynolds", "2 hrs ago", "5.2K", "1.1K", "362")),
            new Item(Constants.ROW_TYPE_POST,new Post(R.drawable.post_user_2, R.drawable.post_2, "Charlie Kelly", "4 hrs ago", "5.2K", "1.1K", "362")),
            new Item(Constants.ROW_TYPE_POST,new Post(R.drawable.post_user_1, R.drawable.post_1, "Dennis Reynolds", "2 hrs ago", "5.2K", "1.1K", "362")),
            new Item(Constants.ROW_TYPE_POST,new Post(R.drawable.post_user_2, R.drawable.post_2, "Charlie Kelly", "4 hrs ago", "5.2K", "1.1K", "362")),
            new Item(Constants.ROW_TYPE_POST,new Post(R.drawable.post_user_1, R.drawable.post_1, "Dennis Reynolds", "2 hrs ago", "5.2K", "1.1K", "362")),
            new Item(Constants.ROW_TYPE_POST,new Post(R.drawable.post_user_2, R.drawable.post_2, "Charlie Kelly", "4 hrs ago", "5.2K", "1.1K", "362"))


    };
    public final Message[] messages = new Message[]{
            new Message("2", "we r goin to c the lions"),
            new Message("2", "they are doing a feed thing event at the zoo.."),
            new Message("1", "when?"),
            new Message("1", "see the lions or sea lions? also, is mac there with u??")
    };
    public final User[] users = new User[]{
            new User(R.drawable.user_profile, "Malena Tudi", "Hey, how’s it goin?"),
            new User(R.drawable.user_profile_2, "Jakob Curtis", "Yo, are you going to the Jake’s wedding?"),
            new User(R.drawable.user_profile_3, "Abram Levin", "Amir said we’d be staying over for a while... but ..."),
            new User(R.drawable.user_profile_4, "Marilyn Herwitz", "hey, i got new memes for you"),
            new User(R.drawable.user_profile_5, "Desirae Saris", "GoT really took a nose dive huh")
    };


}
