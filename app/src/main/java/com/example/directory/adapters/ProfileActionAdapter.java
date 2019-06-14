package com.example.directory.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.directory.R;
import com.example.directory.models.ProfileActionModel;

import java.util.List;

public class ProfileActionAdapter extends RecyclerView.Adapter<ProfileActionAdapter.ViewHolder> {

    List<ProfileActionModel> actionModelList;

    public ProfileActionAdapter(List<ProfileActionModel> actionModelList) {
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
        int resource = actionModelList.get(position).getImageResource();
        int actionName = actionModelList.get(position).getActionName();

        viewHolder.setData(resource, actionName);
    }

    @Override
    public int getItemCount() {
        return actionModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView actionImageView;
        private TextView actionNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            actionImageView = itemView.findViewById(R.id.action_image);
            actionNameTextView = itemView.findViewById(R.id.action_name);
        }

        private void setData(int resource, int actionName) {
            actionImageView.setImageResource(resource);
            actionNameTextView.setText(actionName);
        }
    }
}
