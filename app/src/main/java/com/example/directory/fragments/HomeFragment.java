package com.example.directory.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.directory.R;
import com.example.directory.adapters.ContactListAdapter;
import com.example.directory.models.UserContactModel;
import com.example.directory.utils.HelperUtils;
import com.example.directory.utils.SampleData;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private static final int INITIAL_ICON_POSITION = 50;
    private static final int ADD_ICON_POSITION = 120;

    private ListView contactList;
    private TextView resultCount;
    private ImageView fvrtIcon, allIcon;

    private ContactListAdapter contactListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, parent, false);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        List<UserContactModel> favoriteContacts = SampleData.getFavoriteContacts();

        List<UserContactModel> allContacts = new ArrayList<>();
        allContacts.addAll(favoriteContacts);
        allContacts.addAll(SampleData.getOtherContacts());

        contactList = view.findViewById(R.id.contact_list);

        contactListAdapter = new ContactListAdapter(this, allContacts);
        contactList.setAdapter(contactListAdapter);

        setIconPositions(view, favoriteContacts.size());

        resultCount = view.findViewById(R.id.result_count);
        resultCount.setText(contactList.getCount() + " results found");

        HelperUtils.getListViewSize(contactList);

        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        contactList.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
    }

    private void setIconPositions(View view, int size) {
        fvrtIcon = view.findViewById(R.id.fvrt_icon);
        allIcon = view.findViewById(R.id.all_icon);

        switch (size) {
            case 0:
                fvrtIcon.setVisibility(View.GONE);
                setPadding(allIcon, 0);
                break;
            case 1:
                fvrtIcon.setVisibility(View.VISIBLE);
                setPadding(allIcon, INITIAL_ICON_POSITION);
                break;
            case 2:
                fvrtIcon.setVisibility(View.VISIBLE);
                setPadding(allIcon, INITIAL_ICON_POSITION + ADD_ICON_POSITION);
                break;
            case 3:
                fvrtIcon.setVisibility(View.VISIBLE);
                setPadding(allIcon, INITIAL_ICON_POSITION + (ADD_ICON_POSITION * 2));
                break;
            case 4:
                fvrtIcon.setVisibility(View.VISIBLE);
                setPadding(allIcon, INITIAL_ICON_POSITION + (ADD_ICON_POSITION * 3));
                break;
        }
    }

    private void setPadding(ImageView iv, int top) {
        iv.setPadding(iv.getPaddingLeft(), iv.getPaddingTop() + top, iv.getPaddingRight(), iv.getPaddingBottom());
    }

}
