package com.example.directory.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.directory.R;
import com.example.directory.adapters.ProfileActionAdapter;
import com.example.directory.models.ProfileActionModel;

import java.util.ArrayList;
import java.util.List;

public class ProfileRecyclerViewFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_profile, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        recyclerView = ProfileRecyclerViewFragment.this.getView().findViewById(R.id.recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ProfileRecyclerViewFragment.this.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        List<ProfileActionModel> profileActionModels = new ArrayList<>();
        profileActionModels.add(new ProfileActionModel(R.drawable.ic_home, R.string.profile_item_home));
        profileActionModels.add(new ProfileActionModel(R.drawable.ic_occupation, R.string.profile_item_occupation));
        profileActionModels.add(new ProfileActionModel(R.drawable.ic_office, R.string.profile_item_office));
        profileActionModels.add(new ProfileActionModel(R.drawable.ic_contact, R.string.profile_item_contact_number));
        profileActionModels.add(new ProfileActionModel(R.drawable.ic_email, R.string.profile_item_email));

        ProfileActionAdapter adapter = new ProfileActionAdapter(profileActionModels);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
