package com.example.directory.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.directory.R;
import com.example.directory.adapters.AccountActionListAdapter;
import com.example.directory.fragments.dialog.LogoutConfirmationDialog;

import java.util.ArrayList;
import java.util.HashMap;

public class AccountFragment extends Fragment {

    public static final String KEY_ACTION_ID = "id";
    public static final String KEY_ACTION_NAME = "action_name";
    public static final String KEY_ACTION_IMAGE = "action_image";

    private LinearLayout ll = null;
    private ListView actionList;
    private AccountActionListAdapter adapter;

    private Fragment profileFragment;
    private Fragment profileRecyclerFragment;
    private DialogFragment logoutFragment;
    private FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        ArrayList<HashMap<String, Object>> actions = createActionList();

        ll = view.findViewById(R.id.account_fragment_ll);
        actionList = view.findViewById(R.id.action_list);

        fragmentManager = getFragmentManager();

        actionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch ((int)id) {
                    case 0:
                        profileFragment = new ProfileFragment();
                        fragmentManager.beginTransaction().replace(R.id.container, profileFragment).commit();
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        logoutFragment = new LogoutConfirmationDialog();
                        logoutFragment.show(fragmentManager, "");
                        break;
                }
            }
        });

        adapter = new AccountActionListAdapter(this, actions);
        actionList.setAdapter(adapter);
    }

    private ArrayList<HashMap<String, Object>> createActionList() {
        ArrayList<HashMap<String, Object>> actions = new ArrayList<>();

        HashMap<String, Object> map = new HashMap<>();
        map.put(KEY_ACTION_ID, 1);
        map.put(KEY_ACTION_NAME, R.string.account_action_profile);
        map.put(KEY_ACTION_IMAGE, R.drawable.ic_profile);
        actions.add(map);

        map = new HashMap<>();
        map.put(KEY_ACTION_ID, 2);
        map.put(KEY_ACTION_NAME, R.string.account_action_family_tree);
        map.put(KEY_ACTION_IMAGE, R.drawable.ic_family);
        actions.add(map);

        map = new HashMap<>();
        map.put(KEY_ACTION_ID, 3);
        map.put(KEY_ACTION_NAME, R.string.account_action_setting);
        map.put(KEY_ACTION_IMAGE, R.drawable.ic_setting);
        actions.add(map);

        map = new HashMap<>();
        map.put(KEY_ACTION_ID, 4);
        map.put(KEY_ACTION_NAME, R.string.account_action_logout);
        map.put(KEY_ACTION_IMAGE, R.drawable.ic_logout);
        actions.add(map);

        return actions;
    }
}
