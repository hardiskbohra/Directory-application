package com.example.directory;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.directory.fragments.AccountFragment;
import com.example.directory.fragments.DefaultFragment;
import com.example.directory.fragments.HomeFragment;

public class MainActivity extends BaseActivity {

    private Toolbar toolbar;
    private TextView toolbarTitle;

    int check = 0;

    final private Fragment homeFragment = new HomeFragment();
    final private Fragment accountFragment = new AccountFragment();
    final private Fragment defaultFragment = new DefaultFragment();

    final FragmentManager fragmentManager = getSupportFragmentManager();

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.bottom_action_home:
                    check = 1;
                    fragment = homeFragment;
                    toolbarTitle.setText("Directory List");
                    break;
                case R.id.bottom_action_account:
                    check = 2;
                    fragment = accountFragment;
                    toolbarTitle.setText("My Account");
                    break;
                case R.id.bottom_action_recent:
                    fragment = defaultFragment;
                    toolbarTitle.setText("Recent Activities");
                    break;
                default:
                    fragment = defaultFragment;
                    break;
            }
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        toolbarTitle = toolbar.findViewById(R.id.toolbar_title);

        BottomNavigationView navView = findViewById(R.id.bottom_bar);

        // Set default selection
        navView.setSelectedItemId(R.id.bottom_action_home);
        fragmentManager.beginTransaction().replace(R.id.container, homeFragment).commit();

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        super.setActionBarDrawerToggle(actionBarDrawerToggle);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to show navigation bar icon on tool bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
