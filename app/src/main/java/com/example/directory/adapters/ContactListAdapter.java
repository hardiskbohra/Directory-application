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
import com.example.directory.models.UserContactModel;

import java.util.List;

public class ContactListAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    private Fragment fragment;
    private List<UserContactModel> userContactModels;

    public ContactListAdapter(Fragment f, List<UserContactModel> userContactModels) {
        this.fragment = f;
        this.userContactModels = userContactModels;
        this.inflater = (LayoutInflater) fragment.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return userContactModels.size();
    }

    @Override
    public Object getItem(int position) {
        return userContactModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return userContactModels.get(position).getImage();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null)
            view = inflater.inflate(R.layout.directory_list_row, null);

        ViewHolder viewHolder = new ViewHolder(view);
        UserContactModel contact = userContactModels.get(position);
        viewHolder.setData(contact.getImage(), contact.getName(), contact.getCity(), contact.getNativeCity());
        return view;
    }

    class ViewHolder {

        private ImageView contactIV;
        private TextView contactNameTV;
        private TextView contactValueTV;

        public ViewHolder(@NonNull View itemView) {
            contactIV = itemView.findViewById(R.id.contact_image);
            contactNameTV = itemView.findViewById(R.id.contact_name);
            contactValueTV = itemView.findViewById(R.id.contact_city);
        }

        private void setData(int contactImage, String contactName, String contactCity, String contactNativeCity) {
            contactIV.setImageResource(contactImage);
            contactNameTV.setText(contactName);
            contactValueTV.setText(contactCity + " (" + contactNativeCity + ")");
        }
    }
}
