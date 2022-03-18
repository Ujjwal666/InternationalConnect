package com.example.android_user_registration.fragments;

import android.util.Log;

import com.example.android_user_registration.Party;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;


public class ProfileFragment extends PostsFragment{
    @Override
    protected void queryPosts() {
        super.queryPosts();
        ParseQuery<Party> query = ParseQuery.getQuery(Party.class);
        query.include(Party.KEY_USER);
        query.whereEqualTo(Party.KEY_USER, ParseUser.getCurrentUser());
        query.addDescendingOrder(Party.KEY_CREATED_AT);
        query.findInBackground(new FindCallback<Party>() {
            @Override
            public void done(List<Party> posts, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with getting posts", e);
                    return;
                }

                for (Party post : posts) {
                    Log.i(TAG, "Post: " + post.getDescription() + ", username:" + post.getUser().getUsername());
                }
                mPosts.addAll(posts);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
