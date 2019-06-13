package com.example.mybakingapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MainRecipeCard implements Parcelable {

    private String mRecipeName;
    private String mRecipeServing;

    public MainRecipeCard(String mRecipeName, String mRecipeServing) {
        this.mRecipeName = mRecipeName;
        this.mRecipeServing = mRecipeServing;
    }

    protected MainRecipeCard(Parcel in) {
        mRecipeName = in.readString();
        mRecipeServing = in.readString();
    }

    public static final Creator<MainRecipeCard> CREATOR = new Creator<MainRecipeCard>() {
        @Override
        public MainRecipeCard createFromParcel(Parcel in) {
            return new MainRecipeCard(in);
        }

        @Override
        public MainRecipeCard[] newArray(int size) {
            return new MainRecipeCard[size];
        }
    };

    public String getmRecipeName() {
        return mRecipeName;
    }

    public String getmRecipeServing() {
        return mRecipeServing;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mRecipeName);
        dest.writeString(mRecipeServing);
    }
}
