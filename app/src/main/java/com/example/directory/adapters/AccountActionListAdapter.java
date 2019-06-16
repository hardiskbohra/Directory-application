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
import com.example.directory.constants.Constants;

import java.util.List;
import java.util.Map;

public class AccountActionListAdapter extends BaseAdapter {

    private Fragment fragment;
    private List<Map<String, Object>> actions;
    private static LayoutInflater inflater = null;

    public AccountActionListAdapter(Fragment f, List<Map<String, Object>> actions) {
        this.fragment = f;
        this.actions = actions;
        this.inflater = (LayoutInflater) fragment.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return actions.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        if (view == null)
            view = inflater.inflate(R.layout.account_action_list_row, null);

        ViewHolder viewHolder = new ViewHolder(view);
        Map<String, Object> action = actions.get(position);
        viewHolder.setData((int) action.get(Constants.ICON), (int) action.get(Constants.KEY));

        return view;
    }

    class ViewHolder {

        private ImageView actionIcon;
        private TextView actionName;

        public ViewHolder(@NonNull View view) {
            actionName = view.findViewById(R.id.action_name);
            actionIcon = view.findViewById(R.id.action_image);
        }

        private void setData(int actionImage, int actionName) {
            this.actionIcon.setImageResource(actionImage);
            this.actionName.setText(actionName);
        }
    }
}
