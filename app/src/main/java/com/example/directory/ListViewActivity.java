package com.example.directory;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.directory.adapters.LazyAdapter;
import com.example.directory.utils.ViewUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewActivity extends BaseActivity {

    static final String URL = "https://api.androidhive.info/music/music.xml";

    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_CITY = "city";

    private ListView list;
    private LazyAdapter adapter;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

//        drawerLayout = findViewById(R.id.drawer_layout);
//        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
//        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
//
//        drawerLayout.addDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.syncState();
//
//        // to show navigation bar icon on tool bar
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<HashMap<String, String>> songsList = new ArrayList();

        HashMap<String, String> map = new HashMap<String, String>();
        map.put(KEY_ID, "1");
        map.put(KEY_NAME, "Mr. Tonny Stark");
        map.put(KEY_CITY, "Bangalore (Native1)");
        songsList.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "2");
        map.put(KEY_NAME, "Mr. Captain America");
        map.put(KEY_CITY, "Bangalore (Native2)");
        songsList.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "3");
        map.put(KEY_NAME, "Mr. Dr. Strange");
        map.put(KEY_CITY, "Bangalore (Native3)");
        songsList.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "4");
        map.put(KEY_NAME, "Mr. Steve Smith");
        map.put(KEY_CITY, "Bangalore (Native4)");
        songsList.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "5");
        map.put(KEY_NAME, "Mr. Tonny Stark");
        map.put(KEY_CITY, "Bangalore (Native1)");
        songsList.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "6");
        map.put(KEY_NAME, "Mr. Captain America");
        map.put(KEY_CITY, "Bangalore (Native2)");
        songsList.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "7");
        map.put(KEY_NAME, "Mr. Dr. Strange");
        map.put(KEY_CITY, "Bangalore (Native3)");
        songsList.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "8");
        map.put(KEY_NAME, "Mr. Steve Smith");
        map.put(KEY_CITY, "Bangalore (Native4)");
        songsList.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "9");
        map.put(KEY_NAME, "Mr. Tonny Stark");
        map.put(KEY_CITY, "Bangalore (Native1)");
        songsList.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "10");
        map.put(KEY_NAME, "Mr. Captain America");
        map.put(KEY_CITY, "Bangalore (Native2)");
        songsList.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "11");
        map.put(KEY_NAME, "Mr. Dr. Strange");
        map.put(KEY_CITY, "Bangalore (Native3)");
        songsList.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "12");
        map.put(KEY_NAME, "Mr. Steve Smith");
        map.put(KEY_CITY, "Bangalore (Native4)");
        songsList.add(map);

        list=(ListView)findViewById(R.id.list);

        adapter=new LazyAdapter(this, songsList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

}
