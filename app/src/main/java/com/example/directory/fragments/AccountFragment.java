package com.example.directory.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.directory.R;
import com.example.directory.adapters.AccountActionListAdapter;
import com.example.directory.fragments.dialog.LogoutConfirmationDialog;
import com.example.directory.models.UserProfileModel;
import com.example.directory.utils.SampleData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.directory.constants.Constants.ICON;
import static com.example.directory.constants.Constants.KEY;

public class AccountFragment extends Fragment {


    private ListView actionList;
    private AccountActionListAdapter adapter;

    private Fragment profileFragment;
    private DialogFragment logoutFragment;
    private FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        List<Map<String, Object>> actions = createActionList();
        UserProfileModel userProfile = SampleData.createDataList();

        // set user Profile
        setViewComponent(view, userProfile);

        actionList = view.findViewById(R.id.action_list);

        fragmentManager = getFragmentManager();

        actionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch ((int) id) {
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

    private void setViewComponent(View view, UserProfileModel userProfile) {
        ImageView userImage = view.findViewById(R.id.user_image);
        userImage.setImageResource(userProfile.getImageResource());

        TextView userName = view.findViewById(R.id.user_name);
        userName.setText(userProfile.getName());
    }

    private List<Map<String, Object>> createActionList() {
        List<Map<String, Object>> mapList = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put(ICON, R.drawable.ic_profile);
        map.put(KEY, R.string.account_action_profile);
        mapList.add(map);

        map = new HashMap<>();
        map.put(ICON, R.drawable.ic_family_tree);
        map.put(KEY, R.string.account_action_family_tree);
        mapList.add(map);

        map = new HashMap<>();
        map.put(ICON, R.drawable.ic_settings);
        map.put(KEY, R.string.account_action_setting);
        mapList.add(map);

        map = new HashMap<>();
        map.put(ICON, R.drawable.ic_logout);
        map.put(KEY, R.string.account_action_logout);
        mapList.add(map);

        return mapList;
    }
}
