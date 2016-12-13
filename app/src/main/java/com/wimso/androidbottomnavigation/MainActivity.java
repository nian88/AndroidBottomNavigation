package com.wimso.androidbottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.wimso.androidbottomnavigation.fragment.FavoritesFragment;
import com.wimso.androidbottomnavigation.fragment.HomeFragment;
import com.wimso.androidbottomnavigation.fragment.NotificationFragment;
import com.wimso.androidbottomnavigation.fragment.ProfileFragment;
import com.wimso.androidbottomnavigation.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContent, HomeFragment.newInstance())
                    .commit();
        }

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.action_home:
                fragment = HomeFragment.newInstance();
                break;
            case R.id.action_notifications:
                fragment = NotificationFragment.newInstance();
                break;
            case R.id.action_favorites:
                fragment = FavoritesFragment.newInstance();
                break;
            case R.id.action_search:
                fragment = SearchFragment.newInstance();
                break;
            case R.id.action_profile:
                fragment = ProfileFragment.newInstance();
                break;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flContent, fragment)
                .commit();

        return false;
    }
}
