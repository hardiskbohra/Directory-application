package com.example.directory.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.directory.R;
import com.example.directory.fragments.AccountFragment;

import java.util.ArrayList;
import java.util.HashMap;

public class AccountActionListAdapter extends BaseAdapter {


    private Activity activity;
    private Fragment fragment;
    private ArrayList<HashMap<String, Object>> data;
    private static LayoutInflater inflater=null;

    public AccountActionListAdapter(Fragment f, ArrayList<HashMap<String, Object>> d) {
        fragment = f;
        data=d;
        inflater = (LayoutInflater)fragment.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.account_action_list_row, null);

        TextView name = vi.findViewById(R.id.action_name);
        ImageView image = vi.findViewById(R.id.action_image);

        HashMap<String, Object> action;
        action = data.get(position);

        if (action.get(AccountFragment.KEY_ACTION_NAME) instanceof String) {
            name.setText((String) action.get(AccountFragment.KEY_ACTION_NAME));
        } else {
            name.setText((int) action.get(AccountFragment.KEY_ACTION_NAME));
        }
        image.setImageResource((int) action.get(AccountFragment.KEY_ACTION_IMAGE));

        return vi;
    }
}
