package com.example.directory.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.directory.R;
import com.example.directory.adapters.AccountActionListAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ProfileFragment extends Fragment {

    public static final String KEY_ACTION_ID = "id";
    public static final String KEY_ACTION_NAME = "action_name";
    public static final String KEY_ACTION_IMAGE = "action_image";

    private ListView actionList;
    private AccountActionListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        final ArrayList<HashMap<String, Object>> actions = createActionList();

        actionList = view.findViewById(R.id.action_list);

        actionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch ((int)id) {
                    case 0:
                        actions.get(0).put(KEY_ACTION_NAME, "#59/1, 2nd floor, 13th main, \n Virat nagar road, \n Bommanhalli, Bangalore - 560068");
                        setValueForOtherActions(actions, 1);
                        break;
                    case 1:
                        actions.get(1).put(KEY_ACTION_NAME, "Updated Address");
                        setValueForOtherActions(actions, 2);
                        break;
                    case 2:
                        actions.get(2).put(KEY_ACTION_NAME, "Updated Address");
                        setValueForOtherActions(actions, 3);
                        break;
                    case 3:
                        actions.get(3).put(KEY_ACTION_NAME, "Updated Address");
                        setValueForOtherActions(actions, 4);
                        break;
                    case 4:
                        actions.get(4).put(KEY_ACTION_NAME, "Updated Address");
                        setValueForOtherActions(actions, 5);
                        break;
                }
                adapter = new AccountActionListAdapter(ProfileFragment.this, actions);
                actionList.setAdapter(adapter);
            }
        });

        adapter = new AccountActionListAdapter(this, actions);
        actionList.setAdapter(adapter);
    }

    private void setValueForOtherActions(ArrayList<HashMap<String, Object>> actions, int position) {

        if (position != 1) {
            actions.get(0).put(KEY_ACTION_NAME, R.string.profile_item_home);
        }
        if (position != 2) {
            actions.get(1).put(KEY_ACTION_NAME, R.string.profile_item_occupation);
        }
        if (position != 3) {
            actions.get(2).put(KEY_ACTION_NAME, R.string.profile_item_office);
        }
        if (position != 4) {
            actions.get(3).put(KEY_ACTION_NAME, R.string.profile_item_contact_number);
        }
        if (position != 5) {
            actions.get(4).put(KEY_ACTION_NAME, R.string.profile_item_email);
        }
    }

    private ArrayList<HashMap<String, Object>> createActionList() {
        ArrayList<HashMap<String, Object>> actions = new ArrayList<>();

        HashMap<String, Object> map = new HashMap<>();
        map.put(KEY_ACTION_ID, 1);
        map.put(KEY_ACTION_NAME, R.string.profile_item_home);
        map.put(KEY_ACTION_IMAGE, R.drawable.ic_home_green);
        actions.add(map);

        map = new HashMap<>();
        map.put(KEY_ACTION_ID, 2);
        map.put(KEY_ACTION_NAME, R.string.profile_item_occupation);
        map.put(KEY_ACTION_IMAGE, R.drawable.ic_occupation);
        actions.add(map);

        map = new HashMap<>();
        map.put(KEY_ACTION_ID, 3);
        map.put(KEY_ACTION_NAME, R.string.profile_item_office);
        map.put(KEY_ACTION_IMAGE, R.drawable.ic_office);
        actions.add(map);

        map = new HashMap<>();
        map.put(KEY_ACTION_ID, 4);
        map.put(KEY_ACTION_NAME, R.string.profile_item_contact_number);
        map.put(KEY_ACTION_IMAGE, R.drawable.ic_contact);
        actions.add(map);

        map = new HashMap<>();
        map.put(KEY_ACTION_ID, 5);
        map.put(KEY_ACTION_NAME, R.string.profile_item_email);
        map.put(KEY_ACTION_IMAGE, R.drawable.ic_email);
        actions.add(map);

        return actions;
    }
}
