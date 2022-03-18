package com.example.android_user_registration;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.android_user_registration.fragments.ComposeFragment;
import com.example.android_user_registration.fragments.PostsFragment;
import com.example.android_user_registration.fragments.ProfileFragment;
import com.example.android_user_registration.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class LogoutActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        final FragmentManager fragmentManager= getSupportFragmentManager();
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.action_home:
                    fragment = new PostsFragment();
                    Toast.makeText(LogoutActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_add:
                    fragment = new ComposeFragment();
                    Toast.makeText(LogoutActivity.this, "Compose", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_search:
                    fragment=new SearchFragment();
                    Toast.makeText(LogoutActivity.this, "Searrch", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_profile:
                default:
                    fragment = new ProfileFragment();
                    Toast.makeText(LogoutActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                    break;

            }
            fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
            return true;
        });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);


    }
}