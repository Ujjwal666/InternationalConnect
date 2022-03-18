package com.example.android_user_registration.fragments;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.android_user_registration.Party;
import com.example.android_user_registration.PartyAdapter;
import com.example.android_user_registration.R;
import com.parse.ParseQuery;
import java.util.ArrayList;
import java.util.List;

public class PostsFragment extends Fragment {
    private RecyclerView rvPosts;
    protected PartyAdapter adapter;
    protected List<Party> mPosts;
    public static final String TAG="PostsFragment";
    private SwipeRefreshLayout swipeContainer;
    public PostsFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipeContainer = view.findViewById(R.id.swipeContainer);

        rvPosts=view.findViewById(R.id.rvPosts);
        swipeContainer.setColorSchemeResources(android.R.color.darker_gray,
                android.R.color.background_dark,
                android.R.color.background_light,
                android.R.color.white);
        mPosts= new ArrayList<>();
        adapter= new PartyAdapter(getContext(),mPosts);
        rvPosts.setAdapter(adapter);
        rvPosts.setLayoutManager(new LinearLayoutManager(getContext()));
        swipeContainer.setOnRefreshListener(() -> {
            Toast.makeText(getContext(),"Creating something", Toast.LENGTH_SHORT).show();
            adapter.clear();
            queryPosts();
            Log.i(TAG, "Loading");
            swipeContainer.setRefreshing(false);
        });

        queryPosts();
    }


    protected void queryPosts() {
        ParseQuery<Party> query = ParseQuery.getQuery(Party.class);
        query.include(Party.KEY_USER);
        query.setLimit(20);
        query.addDescendingOrder(Party.KEY_CREATED_AT);
        query.findInBackground((posts, e) -> {
            if (e != null){
                Log.e(TAG, "Issue with getting posts", e);
                return;
            }

            for (Party party: mPosts){
                Log.i(TAG, "Post: " + party.getDescription() + ", username:" + party.getUser().getUsername());
            }
            mPosts.addAll(posts);
            adapter.notifyDataSetChanged();
        });

    }
}
