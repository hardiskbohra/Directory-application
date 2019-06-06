package com.example.directory;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.directory.utils.ViewUtils;

public class BaseActivity extends AppCompatActivity {

    protected ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_aboutus:
                // about us
                ViewUtils.showToastShort(BaseActivity.this, "About us");
                break;
            case R.id.action_settings:
                // settings
                ViewUtils.showToastShort(BaseActivity.this, "Settings");
                break;
            case R.id.action_help:
                ViewUtils.showToastShort(BaseActivity.this, "Help");
                break;
            default:
                // unknown error
        }
        return actionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
