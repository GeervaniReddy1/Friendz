package com.friendz.friendz.app;

import com.friendz.friendz.FetchFeedFromFbService;
import com.friendz.friendz.FriendzApp;
import com.friendz.friendz.fragments.FriendListFragment;
import com.friendz.friendz.fragments.HomeFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dineshkumarbalasubramanian on 28/06/2017 AD.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(FriendzApp friendzApp);

    void inject(HomeFragment homeFragment);

    void inject(FriendListFragment friendListFragment);

    void inject(FetchFeedFromFbService fetchFeedFromFbService);
}
