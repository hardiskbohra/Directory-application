package com.example.directory.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.directory.ListViewActivity;
import com.example.directory.R;

import java.util.ArrayList;
import java.util.HashMap;

public class LazyAdapter extends BaseAdapter {


    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;

    public LazyAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
            vi = inflater.inflate(R.layout.list_row, null);

        TextView name = vi.findViewById(R.id.name);
        TextView city = vi.findViewById(R.id.city);
        ImageView image = vi.findViewById(R.id.list_image);

        HashMap<String, String> song;
        song = data.get(position);

        name.setText(song.get(ListViewActivity.KEY_NAME));
        city.setText(song.get(ListViewActivity.KEY_CITY));
        image.setImageResource(R.drawable.ic_default_male_user);

        return vi;
    }
}
