package com.example.directory.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.directory.R;
import com.example.directory.adapters.ProfileActionAdapter;
import com.example.directory.models.UserProfileModel;
import com.example.directory.utils.SampleData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.directory.constants.Constants.COMMA;
import static com.example.directory.constants.Constants.HYPHEN_WITH_SPACE;
import static com.example.directory.constants.Constants.ICON;
import static com.example.directory.constants.Constants.KEY;
import static com.example.directory.constants.Constants.NEW_LINE;
import static com.example.directory.constants.Constants.VALUE;

public class ProfileFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler_view);
        TextView userParentName = view.findViewById(R.id.user_parent_name);
        userParentName.setVisibility(View.VISIBLE);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ProfileFragment.this.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        UserProfileModel userProfile = SampleData.createDataList();

        // set user Profile
        setViewComponent(view, userProfile);

        // set user details
        List<Map<String, Object>> userDetails = createUserDetailsMap(userProfile);
        ProfileActionAdapter adapter = new ProfileActionAdapter(userDetails);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    private void setViewComponent(View view, UserProfileModel userProfile) {
        ImageView userImage = view.findViewById(R.id.user_image);
        userImage.setImageResource(userProfile.getImageResource());

        TextView userName = view.findViewById(R.id.user_name);
        userName.setText(userProfile.getName());

        TextView fatherName = view.findViewById(R.id.user_parent_name);
        fatherName.setText("S/o " + userProfile.getFatherName());

        TextView dateOfBirth = view.findViewById(R.id.user_dob);
        dateOfBirth.setText(userProfile.getDateOfBirth());

        TextView nativeCity = view.findViewById(R.id.user_native);
        nativeCity.setText(userProfile.getNativeCity());

        TextView city = view.findViewById(R.id.user_city);
        city.setText(userProfile.getCity());
    }

    private List<Map<String, Object>> createUserDetailsMap(UserProfileModel userProfile) {
        List<Map<String, Object>> mapList = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        builder.append(userProfile.getHomeAddressLine1());
        builder.append(NEW_LINE + userProfile.getHomeAddressLine2());
        builder.append(NEW_LINE + userProfile.getHomeAddressLine3());
        builder.append(NEW_LINE + userProfile.getHomeAddressCity() + COMMA);
        builder.append(userProfile.getHomeAddressState() + HYPHEN_WITH_SPACE + userProfile.getHomeAddressPincode());

        Map<String, Object> map = new HashMap<>();
        map.put(ICON, R.drawable.ic_home_green);
        map.put(KEY, R.string.profile_item_home);
        map.put(VALUE, builder.toString());
        mapList.add(map);

        map = new HashMap<>();
        map.put(ICON, R.drawable.ic_occupation);
        map.put(KEY, R.string.profile_item_occupation);
        map.put(VALUE, userProfile.getOccupation());
        mapList.add(map);

        builder = new StringBuilder();
        builder.append(userProfile.getOfficeAddressLine1());
        builder.append(NEW_LINE + userProfile.getOfficeAddressLine2());
        builder.append(NEW_LINE + userProfile.getOfficeAddressLine3());
        builder.append(NEW_LINE + userProfile.getOfficeAddressCity() + COMMA);
        builder.append(userProfile.getOfficeAddressState() + HYPHEN_WITH_SPACE + userProfile.getOfficeAddressPincode());

        map = new HashMap<>();
        map.put(ICON, R.drawable.ic_office);
        map.put(KEY, R.string.profile_item_office);
        map.put(VALUE, builder.toString());
        mapList.add(map);

        map = new HashMap<>();
        map.put(ICON, R.drawable.ic_contact);
        map.put(KEY, R.string.profile_item_contact_number);
        map.put(VALUE, userProfile.getContactNumber() + NEW_LINE + userProfile.getContactNumber2());
        mapList.add(map);

        map = new HashMap<>();
        map.put(ICON, R.drawable.ic_email);
        map.put(KEY, R.string.profile_item_email);
        map.put(VALUE, userProfile.getEmail());
        mapList.add(map);

        return mapList;
    }
}
