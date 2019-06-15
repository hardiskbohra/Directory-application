package com.example.directory.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.directory.R;

import java.util.List;
import java.util.Map;

public class ProfileActionAdapter extends RecyclerView.Adapter<ProfileActionAdapter.ViewHolder> {

    List<Map<String, Object>> actionModelList;

    public ProfileActionAdapter(List<Map<String, Object>> actionModelList) {
        this.actionModelList = actionModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout_profile, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        int resource = (int) actionModelList.get(position).get("icon");
        int actionName = (int) actionModelList.get(position).get("key");
        String actionValue = (String) actionModelList.get(position).get("value");

        viewHolder.setData(resource, actionName, actionValue);
    }

    @Override
    public int getItemCount() {
        return actionModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView actionIV;
        private TextView actionNameTV;
        private TextView actionValueTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            actionIV = itemView.findViewById(R.id.action_image);
            actionNameTV = itemView.findViewById(R.id.action_name);
            actionValueTV = itemView.findViewById(R.id.action_value);
        }

        private void setData(int resource, int actionName, String actionValue) {
            actionIV.setImageResource(resource);
            actionNameTV.setText(actionName);
            actionValueTV.setText(actionValue);
        }
    }
}
