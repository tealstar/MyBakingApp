package com.example.mybakingapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class StepList implements Parcelable {

    private String mStepShortDescription;
    private String mStepDescription;
    private String mStepVideoUrl;

    public StepList(String mStepShortDescription, String mStepDescription, String mStepVideoUrl) {
        this.mStepShortDescription = mStepShortDescription;
        this.mStepDescription = mStepDescription;
        this.mStepVideoUrl = mStepVideoUrl;
    }

    protected StepList(Parcel in) {
        mStepShortDescription = in.readString();
        mStepDescription = in.readString();
        mStepVideoUrl = in.readString();
    }

    public static final Creator<StepList> CREATOR = new Creator<StepList>() {
        @Override
        public StepList createFromParcel(Parcel in) {
            return new StepList(in);
        }

        @Override
        public StepList[] newArray(int size) {
            return new StepList[size];
        }
    };

    public String getmStepShortDescription() {
        return mStepShortDescription;
    }

    public String getmStepDescription() {
        return mStepDescription;
    }

    public String getmStepVideoUrl() {
        return mStepVideoUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mStepShortDescription);
        dest.writeString(mStepDescription);
        dest.writeString(mStepVideoUrl);
    }
}
