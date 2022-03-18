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
import com.hendraanggrian.appcompat.widget.SocialAutoCompleteTextView;
import com.parse.ParseQuery;
import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {
    private RecyclerView rvSearch;
    protected PartyAdapter adapter;
    protected List<Party> mPosts;
    public static final String TAG="SearchFragment";
    private SocialAutoCompleteTextView search_bar;

    public SearchFragment() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search,container,false);
    }




}