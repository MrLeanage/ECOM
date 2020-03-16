package com.devzone.model;

public class Material {
    private int mID = 0;
    private String mName = null;

    public Material(int mID, String mName) {
        this.mID = mID;
        this.mName = mName;
    }

    public Material() {

    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}