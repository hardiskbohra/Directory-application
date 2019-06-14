package com.example.directory.models;

public class ProfileActionModel {

    private int imageResource;

    private int actionName;

    public ProfileActionModel(int imageResource, int actionName) {
        this.imageResource = imageResource;
        this.actionName = actionName;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getActionName() {
        return actionName;
    }
}

