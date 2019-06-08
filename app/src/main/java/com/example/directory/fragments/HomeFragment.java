package com.example.directory.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.directory.R;
import com.example.directory.adapters.DirectoryListAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeFragment extends Fragment {

    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_CITY = "city";

    private ListView favoriteList;
    private ListView allList;
    private TextView resultCount;

    private DirectoryListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        ArrayList<HashMap<String, String>> favorites = createFavoriteList();
        ArrayList<HashMap<String, String>> all = createAllList();

        favoriteList = view.findViewById(R.id.favorite_list);
        allList = view.findViewById(R.id.all_list);

        adapter = new DirectoryListAdapter(this, favorites);
        favoriteList.setAdapter(adapter);

        adapter = new DirectoryListAdapter(this, all);
        allList.setAdapter(adapter);

        resultCount = view.findViewById(R.id.result_count);
        resultCount.setText((favoriteList.getCount() + allList.getCount()) + " results found");

        favoriteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        allList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private ArrayList<HashMap<String, String>> createFavoriteList() {
        ArrayList<HashMap<String, String>> favorites = new ArrayList();

        HashMap<String, String> map = new HashMap<String, String>();
        map.put(KEY_ID, "1");
        map.put(KEY_NAME, "Mr. Tonny Stark");
        map.put(KEY_CITY, "Bangalore (Native1)");
        favorites.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "2");
        map.put(KEY_NAME, "Mr. Captain America");
        map.put(KEY_CITY, "Bangalore (Native2)");
        favorites.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "3");
        map.put(KEY_NAME, "Mr. Dr. Strange");
        map.put(KEY_CITY, "Bangalore (Native3)");
        favorites.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "4");
        map.put(KEY_NAME, "Mr. Steve Smith");
        map.put(KEY_CITY, "Bangalore (Native4)");
        favorites.add(map);

        return favorites;
    }

    private ArrayList<HashMap<String, String>> createAllList() {
        ArrayList<HashMap<String, String>> all = new ArrayList();

        HashMap<String, String> map = new HashMap<String, String>();
        map.put(KEY_ID, "5");
        map.put(KEY_NAME, "Mr. Tonny Stark");
        map.put(KEY_CITY, "Bangalore (Native1)");
        all.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "6");
        map.put(KEY_NAME, "Mr. Captain America");
        map.put(KEY_CITY, "Bangalore (Native2)");
        all.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "7");
        map.put(KEY_NAME, "Mr. Dr. Strange");
        map.put(KEY_CITY, "Bangalore (Native3)");
        all.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "8");
        map.put(KEY_NAME, "Mr. Steve Smith");
        map.put(KEY_CITY, "Bangalore (Native4)");
        all.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "9");
        map.put(KEY_NAME, "Mr. Tonny Stark");
        map.put(KEY_CITY, "Bangalore (Native1)");
        all.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "10");
        map.put(KEY_NAME, "Mr. Captain America");
        map.put(KEY_CITY, "Bangalore (Native2)");
        all.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "11");
        map.put(KEY_NAME, "Mr. Dr. Strange");
        map.put(KEY_CITY, "Bangalore (Native3)");
        all.add(map);

        map = new HashMap<String, String>();
        map.put(KEY_ID, "12");
        map.put(KEY_NAME, "Mr. Steve Smith");
        map.put(KEY_CITY, "Bangalore (Native4)");
        all.add(map);

        return all;
    }
}
