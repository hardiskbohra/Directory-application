package com.example.directory.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.directory.R;
import com.example.directory.models.UserProfileModel;

public class UserProfileAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    private Fragment fragment;
    private UserProfileModel userProfile;

    public UserProfileAdapter(Fragment f, UserProfileModel userProfile) {
        this.fragment = f;
        this.userProfile = userProfile;
        this.inflater = (LayoutInflater) fragment.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null)
            view = inflater.inflate(R.layout.fragment_profile, null);

        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.setData(userProfile.getImageResource(), userProfile.getName(), userProfile.getFatherName(),
                userProfile.getDateOfBirth(), userProfile.getNativeCity(), userProfile.getCity());
        return view;
    }

    class ViewHolder {

        private ImageView userImage;
        private TextView userName;
        private TextView fatherName;
        private TextView dateOfBirth;
        private TextView nativeCity;
        private TextView city;

        public ViewHolder(@NonNull View view) {
            userImage = view.findViewById(R.id.user_image);
            userName = view.findViewById(R.id.user_name);
            fatherName = view.findViewById(R.id.user_parent_name);
            dateOfBirth = view.findViewById(R.id.user_dob);
            nativeCity = view.findViewById(R.id.user_native);
            city = view.findViewById(R.id.user_city);
        }

        private void setData(int userImage, String username, String fatherName, String dob,
                             String nativeCity, String city) {
            this.userImage.setImageResource(userImage);
            this.userName.setText(username);
            this.fatherName.setText(fatherName);
            this.nativeCity.setText(nativeCity);
            this.dateOfBirth.setText(dob);
            this.city.setText(city);
        }
    }
}
